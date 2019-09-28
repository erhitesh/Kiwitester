package BWell.DesktopWeb;

public enum ElementEnum {
	Id,ClassName,Name,TagName,CssSelector,LinkText,PartialLinkText,Xpath;

	public String getElementType() {
		switch (this) {
		case Id:
			return "Id";
		case ClassName:
			return "class";
		case Name:
			return "name";
		case TagName:
			return "tag";
		case CssSelector:
			return "selector";
		case LinkText:
			return "link";
		case PartialLinkText:
			return "partial";
		case Xpath:
			return "xpath";
		default:
			throw new AssertionError("Element Not Found...");
		}
	}
}
