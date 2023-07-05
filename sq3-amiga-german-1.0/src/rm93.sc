;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use Interface)
(use scumSoft)
(use Language)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm93 0
)

(instance rm93 of Rm
	(properties
		picture 93
		style 0
		east 94
		south 91
	)

	(method (init)
		(super init:)
		(self setRegions: 702) ; scumSoft
		(Load rsVIEW 131)
		(Load rsVIEW 132)
		(Load rsVIEW 133)
		(Load rsSOUND 54)
		(gAddToPics
			add:
				prog01
				prog02
				prog03
				prog04
				prog05
				prog06
				prog07
				prog08
				prog09
				prog10
				prog11
				prog12
				prog13
				prog14
				prog15
				prog16
				prog17
				prog18
				prog19
				prog20
				prog21
				prog22
				prog23
				prog24
				prog25
				prog26
		)
		(gAddToPics doit:)
		(rick init:)
		(ken init:)
		(trash1 init:)
		(gEgo init:)
		(if global232
			(= global232 0)
			(trash1 myNerd: 0)
			(if ((gInventory at: 11) ownedBy: gCurRoomNum) ; Keycard
				(keycard init:)
			)
		else
			(= global232 1)
			(elmo init:)
			(trash1 setCel: (= [global567 0] 0))
			(trash1 vaporized: 0)
		)
		(self setScript: rmScript)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 94)
			(gLongSong stop:)
		)
		(gTimers eachElementDo: #dispose 84)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look,look[/area]')
						(if global232
							(Print 93 0) ; "You are in the boss' cubicle area and the boss is in. Be reverent."
						else
							(Print 93 1) ; "You are in the boss' cubicle area and the boss is out. Be yourself."
						)
					)
					((Said 'look,look/man,boss')
						(if (and global232 (gEgo inRect: 225 86 320 149))
							(Print 93 2) ; "Behind the desk sits a boy who looks to be about 14 years old. "Do your job and get out" he blurbs."
						else
							(Print 93 3) ; "Over the top of the partitions you can see two gentlemen cracking whips. You assume that it must be the programming department."
						)
					)
					((Said '/whip')
						(Print 93 4) ; "Better keep your distance!"
					)
					((Said 'talk,talk/man,boy,elmo,boss,bystander')
						(if (and global232 (gEgo inRect: 225 86 320 149))
							(Print 93 5) ; ""Just do your job and scram", he bellows in response."
						else
							(Print 93 6) ; "Your words fall on deaf ears."
						)
					)
					((Said 'look,look,open,explore,unlock/desk,drawer')
						(if (gEgo inRect: 225 86 320 149)
							(cond
								(global232
									(Print 93 7) ; "Don't be foolish!"
								)
								(((gInventory at: 11) ownedBy: gCurRoomNum) ; Keycard
									(Print 93 8) ; "All of the desk drawers are locked. However, someone has carelessly left a keycard on the desk."
								)
								(else
									(Print 93 9) ; "All of the desk drawers are locked."
								)
							)
						else
							(Print 93 10) ; "You're not in a position to do that."
						)
					)
					((Said 'get,get/key,card')
						(cond
							(global232
								(Print 93 11) ; "Not a wise choice at this time."
							)
							(((gInventory at: 11) ownedBy: gCurRoomNum) ; Keycard
								(if (gEgo inRect: 275 89 300 104)
									(gEgo get: 11) ; Keycard
									(keycard dispose:)
									(Print 93 12) ; "You take the keycard."
									(gGame changeScore: 5)
								else
									(Print 93 13) ; "You're not near one."
								)
							)
							((gEgo has: 11) ; Keycard
								(Print 93 14) ; "You already have the keycard."
							)
							(else
								(Print 93 15) ; "That is not available."
							)
						)
					)
				)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 94)
			(gEgo posn: 318 65 view: 113)
		)
		(gEgo init:)
		(if (== gPrevRoomNum 94)
			(gEgo setMotion: MoveTo 288 65 self)
		)
	)

	(method (doit)
		(super doit:)
		(if (not global233)
			(if
				(and
					(== (ken loop:) 0)
					(< (rick loop:) 2)
					(== 10 (Random 1 20))
				)
				(if (== (kenScript state:) 1)
					(kenScript start: 1)
				else
					(kenScript start: 0)
				)
				(ken setScript: kenWhip)
			)
			(if
				(and
					(== (rick loop:) 0)
					(< (ken loop:) 2)
					(== 10 (Random 1 20))
				)
				(if (== (rickScript state:) 0)
					(rickScript start: 0)
				else
					(rickScript start: 1)
				)
				(rick setScript: rickWhip)
			)
		)
	)
)

(instance trash1 of TrashBasket
	(properties
		nearWest 225
		nearNorth 86
		nearEast 320
		nearSouth 149
	)

	(method (init)
		(super init:)
		(self posn: 256 103 myNerd: elmo)
	)
)

(instance elmo of Nerd
	(properties)

	(method (init)
		(super init:)
		(self
			view: (LangSwitch 115 323)
			setLoop: 8
			posn: 263 84
			setPri: 6
			speakX: 167
			speakY: 75
			speakCel: 0
		)
	)
)

(instance keycard of View
	(properties)

	(method (init)
		(self
			view: (LangSwitch 115 323)
			setLoop: 9
			setCel: 1
			setPri: 6
			posn: 285 92
		)
		(super init:)
	)
)

(class ProgPri14 of PicView
	(properties
		view 133
		priority 14
		signal 16384
	)
)

(class ProgPri4 of PicView
	(properties
		view 133
		cel 1
		priority 4
		signal 16384
	)
)

(class ProgPri2 of PicView
	(properties
		view 133
		cel 1
		priority 2
		signal 16384
	)
)

(instance prog01 of ProgPri14
	(properties
		x 176
		y 181
	)
)

(instance prog02 of ProgPri14
	(properties
		x 175
		y 150
	)
)

(instance prog03 of ProgPri14
	(properties
		x 173
		y 118
	)
)

(instance prog04 of ProgPri14
	(properties
		x 171
		y 87
	)
)

(instance prog05 of ProgPri14
	(properties
		x 170
		y 54
	)
)

(instance prog06 of ProgPri14
	(properties
		x 170
		y 24
	)
)

(instance prog07 of ProgPri14
	(properties
		x 134
		y 181
	)
)

(instance prog08 of ProgPri14
	(properties
		x 138
		y 150
	)
)

(instance prog09 of ProgPri14
	(properties
		x 140
		y 118
	)
)

(instance prog10 of ProgPri14
	(properties
		x 141
		y 87
	)
)

(instance prog11 of ProgPri14
	(properties
		x 141
		y 55
	)
)

(instance prog12 of ProgPri14
	(properties
		x 143
		y 24
	)
)

(instance prog13 of ProgPri4
	(properties
		x 56
		y 181
	)
)

(instance prog14 of ProgPri4
	(properties
		x 63
		y 150
	)
)

(instance prog15 of ProgPri4
	(properties
		x 70
		y 118
	)
)

(instance prog16 of ProgPri4
	(properties
		x 78
		y 87
	)
)

(instance prog17 of ProgPri4
	(properties
		x 88
		y 55
	)
)

(instance prog18 of ProgPri4
	(properties
		x 96
		y 24
	)
)

(instance prog19 of ProgPri2
	(properties
		x 16
		y 181
	)
)

(instance prog20 of ProgPri2
	(properties
		x 26
		y 150
	)
)

(instance prog21 of ProgPri2
	(properties
		x 37
		y 118
	)
)

(instance prog22 of ProgPri2
	(properties
		x 48
		y 87
	)
)

(instance prog23 of ProgPri2
	(properties
		x 59
		y 55
	)
)

(instance prog24 of ProgPri2
	(properties
		x 72
		y 24
	)
)

(instance prog25 of ProgPri2
	(properties
		x 26
		y 24
	)
)

(instance prog26 of ProgPri2
	(properties
		x 10
		y 56
	)
)

(instance rick of Actor
	(properties)

	(method (init)
		(self
			ignoreHorizon: 1
			view: 131
			x: 116
			y: -5
			setPri: 14
			setCycle: Fwd
			setStep: 1 1
			ignoreActors: 1
			ignoreControl: -1
			setScript: rickScript
		)
		(super init:)
	)
)

(instance rickScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rick setLoop: 0 setMotion: MoveTo 97 148 self)
			)
			(1
				(rick setLoop: 1 setMotion: MoveTo 116 -5 self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance ken of Actor
	(properties)

	(method (init)
		(self
			ignoreHorizon: 1
			view: 132
			x: -11
			y: 136
			setPri: 14
			setCycle: Fwd
			setStep: 1 1
			ignoreActors: 1
			ignoreControl: -1
			setScript: kenScript
		)
		(super init:)
	)
)

(instance kenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ken setLoop: 1 setMotion: MoveTo 48 -5 self)
			)
			(1
				(ken setLoop: 0 setMotion: MoveTo -11 136 self)
			)
			(2
				(kenScript start: 0)
				(self init:)
			)
		)
	)
)

(instance rickWhip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rick
					setLoop: (if (<= 5 (Random 1 10)) 2 else 3)
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
				(whipSound play:)
			)
			(1
				(if (!= (whipSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 3)
				else
					(rick setCycle: Fwd setLoop: 0 setScript: rickScript)
				)
			)
			(else
				(self init:)
			)
		)
	)
)

(instance kenWhip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ken setLoop: 2 setCel: 0 setMotion: 0 setCycle: End self)
				(whipSound play:)
			)
			(1
				(if (!= (whipSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 3)
				else
					(ken setCycle: Fwd setLoop: 0 setScript: kenScript)
				)
			)
			(else
				(self init:)
			)
		)
	)
)

(instance whipSound of Sound
	(properties
		number 54
		priority 1
	)
)

