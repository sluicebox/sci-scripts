;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Interface)
(use MiracleGro)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm019 0
)

(instance rm019 of PQRoom
	(properties
		picture 19
		east -1
		west 18
	)

	(method (init)
		(if (== gDay 1)
			(LoadMany rsVIEW 124 125 2 3)
		else
			(LoadMany rsVIEW 6 126 123 7)
		)
		(self setRegions: 891) ; station
		(if (>= global105 18)
			(nightWin init:)
		)
		(psychDoor init:)
		(briefDoor init:)
		(lockDoor init:)
		(backWindow init:)
		(briefWindow init:)
		(psychWindow init:)
		(theCarpet init:)
		(smokeAlarm init:)
		(theRoom init:)
		(rmSound init: setVol: 6 play:)
		(switch gPrevRoomNum
			(22
				(gEgo view: (if (> gDay 1) 6 else 2) posn: 155 125)
				(HandsOff)
				(self setScript: exitBrief)
			)
			(23
				(ClearFlag 217)
				(gEgo
					view: (if (> gDay 1) 6 else 2)
					setPri: -1
					posn: 302 125
				)
				(HandsOff)
				(self setScript: exitPsych)
			)
			(18
				(ClearFlag 217)
				(HandsOff)
				(if (< (gEgo y:) 120)
					(gEgo
						view: (if (> gDay 1) 7 else 3)
						setStep: 3 2
						posn: 182 108
					)
					(self posn: 206 108 setScript: (ScriptID 896 1)) ; sWI
				else
					(gEgo
						view: (if (> gDay 1) 123 else 124)
						setStep: 5 1
						posn: -20 164
					)
					(self posn: 20 164 setScript: (ScriptID 896 1)) ; sWI
				)
			)
			(else
				(HandsOn)
				(gEgo
					view: (if (> gDay 1) 123 else 124)
					posn: 186 160
					setStep: 5 1
				)
			)
		)
		(gEgo init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 160 0 0 319 0 319 189 0 189 0 171 263 171 263 127 288 127 283 122 263 122 263 107 188 107 188 50 184 50 184 111 219 111 219 122 160 122 155 127 219 127 219 160
					yourself:
				)
		)
		(egoBluGro
			init:
				egoBluViews
				124
				125
				2
				2
				3
				2
				2
				2
				125
				124
				1
				5
				1
				2
				123
				126
				6
				2
				3
				2
				2
				6
				126
				123
				1
				5
				1
				2
			color: 2
			who: gEgo
		)
		(egoGrnGro
			init:
				egoGrnViews
				3
				125
				2
				0
				3
				2
				1
				2
				125
				3
				3
				3
				2
				1
				7
				126
				6
				0
				3
				3
				1
				6
				126
				7
				3
				3
				3
				1
			color: 4
			who: gEgo
		)
		(super init:)
	)

	(method (doit)
		(cond
			((& ((egoBluGro who:) onControl: 1) (egoBluGro color:))
				(egoBluGro doit:)
			)
			((& ((egoGrnGro who:) onControl: 1) (egoGrnGro color:))
				(egoGrnGro doit:)
			)
			(script 0)
			((& (gEgo onControl: 0) $0010)
				(gCurRoom newRoom: 22)
			)
			((& (gEgo onControl: 1) $0008)
				(HandsOff)
				(self posn: 182 108 setScript: (ScriptID 896 2) 0 18) ; sWO
			)
		)
		(super doit:)
	)

	(method (dispose)
		(egoBluGro dispose:)
		(egoGrnGro dispose:)
		(DisposeScript 892)
		(DisposeScript 894)
		(super dispose:)
	)
)

(instance egoBluGro of MiracleGro
	(properties)
)

(instance egoBluViews of List
	(properties)
)

(instance egoGrnGro of MiracleGro
	(properties)
)

(instance egoGrnViews of List
	(properties)
)

(instance enterBrief of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 161 124 self)
			)
			(1
				(gCurRoom newRoom: 22)
				(self dispose:)
			)
		)
	)
)

(instance exitBrief of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 182 125 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterPsych of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 275 125 self)
			)
			(1
				(psychDoor setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 302 125 self)
			)
			(3
				(gCurRoom newRoom: 23)
				(self dispose:)
			)
		)
	)
)

(instance exitPsych of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(psychDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 275 125 self)
			)
			(2
				(psychDoor setCycle: Beg self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance briefDoor of Feature
	(properties
		x 186
		y 122
		description {Briefing's Room Door}
		onMeCheck 4096
		lookStr {That's the door to the Briefing Room.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: enterBrief)
			)
			(4 ; Inventory
				(Print 19 0) ; "That's unnecessary. Just walk through the door."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance psychDoor of Prop
	(properties
		x 297
		y 130
		description {Psychologist's Door}
		lookStr {That's the door to the Criminal Psychologist's office.}
		view 140
		loop 1
		priority 5
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gEgo setScript: enterPsych)
			)
			(4 ; Inventory
				(Print 19 1) ; "That's unnecessary. Just open the door."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lockDoor of Feature
	(properties
		x 56
		y 142
		noun {door}
		nsTop 60
		nsLeft 31
		nsBottom 142
		nsRight 78
		description {locked door}
		lookStr {That's the door to Vice.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 19 2) ; "The Vice door is locked."
			)
			(4 ; Inventory
				(Print 19 3) ; "That won't get you anywhere."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nightWin of Prop
	(properties
		x 226
		y 93
		description {the window}
		lookStr {The window overlooks scenic downtown Lytton.}
		view 140
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 19 4) ; "You don't need to open the window."
			)
			(4 ; Inventory
				(Print 19 3) ; "That won't get you anywhere."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance backWindow of Feature
	(properties
		x 225
		y 97
		nsTop 73
		nsLeft 197
		nsBottom 97
		nsRight 256
		lookStr {The window overlooks scenic downtown Lytton.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 19 4) ; "You don't need to open the window."
			)
			(4 ; Inventory
				(Print 19 3) ; "That won't get you anywhere."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance briefWindow of Feature
	(properties
		x 225
		y 130
		nsTop 64
		nsLeft 122
		nsBottom 108
		nsRight 138
		lookStr {The window is in the Vice Office.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 19 4) ; "You don't need to open the window."
			)
			(4 ; Inventory
				(Print 19 3) ; "That won't get you anywhere."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance psychWindow of Feature
	(properties
		x 280
		y 96
		nsTop 72
		nsLeft 276
		nsBottom 96
		nsRight 283
		lookStr {The window is in the Psychologist's Office. The blinds are shut.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 19 4) ; "You don't need to open the window."
			)
			(4 ; Inventory
				(Print 19 3) ; "That won't get you anywhere."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smokeAlarm of Feature
	(properties
		x 10
		y 10
		description {carpet}
		onMeCheck 64
		lookStr {It's a smoke detector! A small label on the side reads: "For best results, hold directly over flame".}
	)
)

(instance theCarpet of Feature
	(properties
		x 180
		y 83
		description {carpet}
		onMeCheck 16390
		lookStr {Hmm, 'policeman blue'.}
	)
)

(instance theRoom of Feature
	(properties
		lookStr {You're in the hallway of the second level of the Lytton Police Station. Several office doors line the hallway.}
	)
)

(instance rmSound of Sound
	(properties
		flags 1
		number 181
		loop -1
	)
)

