;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use eRS)
(use Interface)
(use LoadMany)
(use Actor)
(use System)

(public
	rm110 0
)

(procedure (ShadowPrint theText atX)
	(Display
		theText
		dsCOORD
		(+ atX 1)
		43
		dsWIDTH
		158
		dsALIGN
		alCENTER
		dsCOLOR
		gColBlack
		dsFONT
		gNiceFont
	)
	(Display theText dsCOORD atX 42 dsWIDTH 158 dsALIGN alCENTER dsCOLOR 61 dsFONT gNiceFont)
)

(instance rm110 of LLRoom
	(properties
		picture 115
	)

	(method (init)
		(larryPic init:)
		(self style: (if (IsFlag 0) 9 else 8)) ; isVga
		(super init:)
		(LoadMany rsPIC 1)
		(LoadMany rsVIEW 115 116)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(SetFFRoom 120)
		(self setScript: sCartoon)
	)

	(method (handleEvent event)
		(if
			(and
				(event type:)
				(!= (event message:) KEY_ESCAPE)
				(!= (event message:) KEY_ALT_a)
				(!= (event message:) KEY_ALT_r)
				(!= (event message:) KEY_ALT_t)
			)
			(Print 110 0 80 {Fast Forward} 82 990 11 0 106 81 {OK} 1) ; "Throughout this game, you can "Zap" ahead by clicking this Fast Forward button, which is in the icon bar at the top of this window."
			(event claimed: 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gTheMusic fade: 0 15 12 1)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState &tmp [str 100])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: (gCurRoom picture:))
				(ShadowPrint {Executive Producer\n\nKen Williams} 160)
				(= seconds 4)
			)
			(2
				(gCurRoom drawPic: (gCurRoom picture:))
				(ShadowPrint {Creative Director\n\nBill Davis} 160)
				(= seconds 4)
			)
			(3
				(gCurRoom drawPic: (gCurRoom picture:))
				(ShadowPrint {Director\n\nAl Lowe} 160)
				(= seconds 4)
			)
			(4
				(gCurRoom drawPic: (gCurRoom picture:))
				(ShadowPrint {Producer\n\nGuruka Singh Khalsa} 160)
				(= seconds 3)
			)
			(5
				(gCurRoom drawPic: (gCurRoom picture:))
				(larryPic dispose:)
				(pattiPic init:)
				(= ticks 120)
			)
			(6
				(gCurRoom drawPic: (gCurRoom picture:))
				(ShadowPrint {Game Designer\n\nAl Lowe} 0)
				(= seconds 4)
			)
			(7
				(gCurRoom drawPic: (gCurRoom picture:))
				(ShadowPrint {Production Designer\n\nAndy Hoyos} 0)
				(= seconds 4)
			)
			(8
				(gCurRoom drawPic: (gCurRoom picture:))
				(ShadowPrint {Art Designer\n\nJane Cardinal} 0)
				(= seconds 4)
			)
			(9
				(gCurRoom drawPic: (gCurRoom picture:))
				(ShadowPrint {Lead Programmer\n\nBrian K. Hughes} 0)
				(= seconds 4)
			)
			(10
				(gCurRoom drawPic: (gCurRoom picture:))
				(ShadowPrint {Composer\n\nCraig Safan} 0)
				(= seconds 4)
			)
			(11
				(gTheMusic fade: 0 15 12 1)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 1 6)
				(= seconds 3)
			)
			(12
				(TPrint 110 1) ; "An East Coast meeting is not going too well...."
				(gTheIconBar enable:)
				(gCurRoom newRoom: 120)
				(self dispose:)
			)
		)
	)
)

(instance pattiPic of View
	(properties
		x 170
		y 177
		view 115
		signal 17
	)
)

(instance larryPic of View
	(properties
		x 173
		y 179
		view 116
		signal 17
	)
)

