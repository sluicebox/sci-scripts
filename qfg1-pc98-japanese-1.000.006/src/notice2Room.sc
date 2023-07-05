;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use FileSelector)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	notice2Room 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(switch local4
		(1
			(local3 posn: 249 90 forceUpd:)
		)
		(2
			(local3 posn: 249 119 forceUpd:)
		)
		(3
			(local3 posn: 249 153 forceUpd:)
		)
	)
)

(procedure (localproc_1 &tmp temp0)
	(switch local4
		(1
			(= temp0 200)
		)
		(2
			(= temp0 202)
		)
		(3
			(gGame restore:)
			(return)
		)
	)
	(gCurRoom newRoom: temp0)
)

(instance wanted of PV
	(properties
		y 59
		x 109
		view 100
	)

	(method (init)
		(= view (LangSwitch 100 105))
		(super init: &rest)
	)
)

(instance forThe of PV
	(properties
		y 74
		x 108
		view 100
		cel 1
	)

	(method (init)
		(= view (LangSwitch 100 105))
		(super init: &rest)
	)
)

(instance village of PV
	(properties
		y 93
		x 109
		view 100
		cel 2
	)

	(method (init)
		(= view (LangSwitch 100 105))
		(super init: &rest)
	)
)

(instance emblem of PV
	(properties
		y 163
		x 106
		view 100
		loop 1
	)
)

(instance nail1 of PV
	(properties
		y 165
		x 47
		view 100
		loop 1
		cel 1
	)
)

(instance nail2 of PV
	(properties
		y 47
		x 46
		view 100
		loop 1
		cel 2
	)
)

(instance nail3 of PV
	(properties
		y 48
		x 170
		view 100
		loop 1
		cel 1
	)
)

(instance scorp of Act
	(properties
		y 200
		x 80
		view 100
	)
)

(instance notice2Room of Rm
	(properties
		picture 100
		style 1
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW (LangSwitch 100 105))
		(gMouseHandler add: self)
		(gKeyHandler add: self)
		(gDirHandler add: self)
		(gAddToPics
			add: wanted forThe village emblem nail1 nail2 nail3
			eachElementDo: #init
			doit:
		)
		((= local0 (View new:))
			view: 100
			loop: 2
			cel: 0
			posn: 249 87
			setPri: 0
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((= local1 (View new:))
			view: 100
			loop: 2
			cel: 0
			posn: 249 116
			setPri: 0
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((= local2 (View new:))
			view: 100
			loop: 2
			cel: 2
			posn: 249 150
			setPri: 0
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		(RedrawCast)
		(SaveSubLang)
		(Display
			{Introduction%j\b2\dd\c4\db\c0\de\b8\bc\ae\dd}
			dsCOORD
			213
			76
			dsALIGN
			alLEFT
			dsFONT
			300
			dsCOLOR
			6
		)
		(Display
			{Start New Hero%j\bd\c0\b0\c4 \c6\ad\b0\cb\b0\db\b0}
			dsCOORD
			205
			105
			dsALIGN
			alLEFT
			dsFONT
			300
			dsCOLOR
			6
		)
		(Display
			{Continue Quest%j \b8\b4\bd\c4\c9\c2\c2\de\b7}
			dsCOORD
			206
			139
			dsALIGN
			alLEFT
			dsFONT
			300
			dsCOLOR
			6
		)
		(Display
			{Introduction%j\b2\dd\c4\db\c0\de\b8\bc\ae\dd}
			dsCOORD
			212
			76
			dsALIGN
			alLEFT
			dsFONT
			300
			dsCOLOR
			0
		)
		(Display
			{Start New Hero%j\bd\c0\b0\c4 \c6\ad\b0\cb\b0\db\b0}
			dsCOORD
			204
			105
			dsALIGN
			alLEFT
			dsFONT
			300
			dsCOLOR
			0
		)
		(Display
			{Continue Quest%j \b8\b4\bd\c4\c9\c2\c2\de\b7}
			dsCOORD
			205
			139
			dsALIGN
			alLEFT
			dsFONT
			300
			dsCOLOR
			0
		)
		(RestoreSubLang)
		(= local4 1)
		((= local3 (View new:))
			view: 100
			setLoop: 2
			setCel: 3
			posn: 249 90
			setPri: 1
			init:
			ignoreActors:
			stopUpd:
		)
		(scorp
			illegalBits: 0
			ignoreActors: 1
			init:
			setLoop: 3
			setCycle: Fwd
			setStep: 1 1
			setPri: 13
			setScript: scorpS
		)
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(gKeyHandler delete: self)
		(gDirHandler delete: self)
		(User canControl: 1)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (or (Said 'look,look/bug,scorpion') (MouseClaimed scorp event 3))
			(HighPrint 9 0) ; "Congratulations! You have discovered the first bug in this game."
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(= temp1 0)
				(switch (= temp0 (OnControl CONTROL (event x:) (event y:)))
					(2
						(= temp1 1)
					)
					(4
						(= temp1 2)
					)
					(8
						(= temp1 3)
					)
				)
				(event claimed: 1)
				(localproc_0)
				(if temp1
					(= local4 temp1)
					(localproc_0)
					(RedrawCast)
					(localproc_1)
				)
			)
			($0040 ; direction
				(switch (event message:)
					(JOY_UP
						(if (== local4 1)
							(= local4 3)
						else
							(-- local4)
						)
					)
					(JOY_DOWN
						(if (== local4 3)
							(= local4 1)
						else
							(++ local4)
						)
					)
				)
				(event claimed: 1)
				(localproc_0)
				(RedrawCast)
			)
			(evKEYBOARD
				(switch (event message:)
					(KEY_RETURN
						(localproc_1)
					)
					(KEY_SHIFTTAB
						(if (== local4 1)
							(= local4 3)
						else
							(-- local4)
						)
					)
					(KEY_TAB
						(if (== local4 3)
							(= local4 1)
						else
							(++ local4)
						)
					)
				)
				(event claimed: 1)
				(localproc_0)
				(RedrawCast)
			)
		)
		(super handleEvent: event)
	)
)

(instance scorpS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(scorp setMotion: MoveTo (Random 85 90) 160 self)
			)
			(1
				(scorp setCycle: 0)
				(= seconds (Random 2 3))
			)
			(2
				(scorp setCycle: Fwd setMotion: MoveTo (Random 75 85) 90 self)
			)
			(3
				(scorp setCycle: 0)
				(= seconds (Random 2 3))
			)
			(4
				(scorp setCycle: Fwd setMotion: MoveTo 80 0 self)
			)
			(5
				(scorp dispose: delete:)
			)
		)
	)
)

