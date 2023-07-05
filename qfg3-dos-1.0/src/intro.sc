;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use GloryWindow)
(use IconBar)
(use GameControls)
(use Game)
(use System)

(public
	intro 0
)

(local
	[local0 10]
	[local10 10]
	local20
)

(procedure (localproc_0)
	(Message msgGET 61 1 6 2 1 @local0) ; "Yes"
	(Message msgGET 61 1 6 3 1 @local10) ; "No"
	(quest init: show: dispose:)
	(return local20)
)

(instance intro of Rgn
	(properties)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (IsObject gFastCast)
			(super handleEvent: event &rest)
		else
			(cond
				((event claimed:) 0)
				((OneOf (event type:) evKEYBOARD evMOUSEBUTTON evJOYDOWN)
					(event claimed: 1)
					(gSounds eachElementDo: #pause 1)
					(if (localproc_0)
						(gSounds eachElementDo: #pause 0)
						(gCurRoom newRoom: 280)
					)
					(gSounds eachElementDo: #pause 0)
				)
				((== (event type:) evMOUSERELEASE)
					(event claimed: 1)
				)
			)
			(super handleEvent: event &rest)
		)
	)
)

(instance quest of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		((= window (GloryWindow new:))
			top: 60
			left: 97
			bottom: 115
			right: 223
			priority: 15
			yourself:
		)
		(self add: titleIcon yesIcon noIcon)
		(super init: &rest)
	)
)

(instance titleIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 0
		signal 4
		maskView 361
		maskLoop 3
	)

	(method (show &tmp [temp0 30])
		(Message msgGET 61 1 6 1 1 @temp0) ; "Do you want to skip the introduction?"
		(Display @temp0 dsWIDTH 135 dsCOORD 5 3 dsCOLOR 17)
	)
)

(instance yesIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 25
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local20 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local0 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local0 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance noIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 40
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local20 0)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local10 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local10 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

