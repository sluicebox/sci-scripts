;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Blk)
(use DPath)
(use Wander)
(use Follow)
(use Chase)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm015 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm015 of Rm
	(properties
		picture 15
		style 0
		horizon 87
		north 8
		east 16
		south 22
		picAngle 70
	)

	(method (init)
		(Load rsSOUND 17)
		(Load rsSOUND 43)
		(Load rsSOUND 44)
		(Load rsSOUND 41)
		(Load rsSOUND 16)
		(Load rsSOUND 2)
		(Load rsVIEW 83)
		(Load rsVIEW 76)
		(Load rsVIEW 64)
		(Load rsVIEW 127)
		(Load rsVIEW 300)
		(Load rsVIEW 58)
		(Load rsVIEW 39)
		(super init:)
		(= global207 0)
		(= global125 -1)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(8
				(gEgo posn: 307 89)
			)
			(16
				(gEgo y: (+ (/ (* (- (gEgo y:) 95) 100) 93) 88))
			)
			(22
				(gEgo x: (+ (/ (* (- (gEgo x:) 80) 30) 19) 17))
			)
			(40
				(gEgo loop: 0 x: 182 y: 118 edgeHit: 0)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(self setScript: closeDoorScript)
			)
			(else
				(gEgo posn: 160 125)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
			)
		)
		(if global131
			(smoke init:)
		else
			(smoke init: addToPic:)
		)
		(gAddToPics
			add:
				flower
				((Clone flower) loop: 1 cel: 1 x: 2 y: 188)
				((Clone flower) loop: 1 cel: 2 x: 4 y: 182)
				((Clone flower) loop: 2 cel: 2 x: 4 y: 185)
				((Clone flower) loop: 2 cel: 1 x: 1 y: 190)
				((Clone flower) loop: 2 cel: 2 x: 37 y: 182 15)
			eachElementDo: #init
			doit:
		)
		(gEgo init:)
		(proc0_10)
		(if (not [global675 15])
			(man init:)
			(if (proc0_11 58)
				(= [global675 15] 1)
				(= global206 gSpeed)
				(switch global131
					(0
						(gGame setSpeed: 4)
					)
					(1
						(gGame setSpeed: 5)
					)
					(2
						(gGame setSpeed: 6)
					)
				)
				(self setScript: rhymeScript)
			)
		else
			(= local5 1)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 23)
						(== local6 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 23) (== local6 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 23) (== local6 1))
					(rhymeScript cycles: 1)
				)
				(if
					(and
						(& temp0 emSHIFT)
						(!= local5 1)
						(proc0_16 event 260 136 276 160)
					)
					(LookAt man)
					(man setScript: talkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(if (and (gEgo inRect: 172 111 181 128) (!= script openDoorScript))
			(self setScript: openDoorScript)
		)
		(super doit:)
		(if (> (gEgo distanceTo: man) 60)
			(= global108 0)
		)
		(if
			(and
				(not [global675 15])
				(not global108)
				(< (gEgo distanceTo: man) 30)
			)
			(= global108 1)
			(LookAt man)
			(man setScript: talkScript)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGlobalMGSound stop:)
				(doorSound number: 17 loop: 1 play:)
				(door setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 40)
			)
		)
	)
)

(instance closeDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door setCycle: Beg self)
				(doorSound number: 43 loop: 1 play:)
			)
			(1
				(door stopUpd:)
				(doorSound number: 44 loop: 1 play: self)
			)
			(2
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local5 1)
				(HandsOff)
				(man setLoop: 4 setCycle: Fwd cycleSpeed: 1 setMotion: 0)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{You there!\nBring me my\nsixpence!}
					dsWIDTH
					80
					dsCOORD
					174
					70
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(rhymeSound number: 41 loop: 1 play:)
				(= seconds global120)
			)
			(1
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(man setCel: 0)
				(= seconds global121)
			)
			(2
				(itemVisual hide:)
				(itemBalloon hide:)
				(man setLoop: -1 setCel: -1 setCycle: Walk cycleSpeed: 0)
				(paceS cue:)
				(= global103 0)
				(= local5 0)
				(HandsOn)
			)
		)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local5 1)
				(= global209 1)
				(HandsOff)
				(man setScript: 0 setMotion: MoveTo 270 153)
				(cond
					((and (< (gEgo y:) 92) (< (gEgo x:) 295))
						(gEgo
							setAvoider: Avoid
							setMotion: MoveTo 300 90 self
						)
					)
					((and (> (gEgo y:) 178) (< (gEgo x:) 295))
						(gEgo
							setAvoider: Avoid
							setMotion: MoveTo 300 180 self
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(gEgo setAvoider: Avoid setMotion: MoveTo 292 153 self)
			)
			(2
				(proc0_18)
				(gEgo setLoop: 1)
				(= cycles 25)
			)
			(3
				(gEgo setLoop: -1 setMotion: MoveTo 300 180 self)
			)
			(4
				(gEgo setLoop: 3 stopUpd:)
				(man
					view: 83
					setAvoider: Avoid
					setCycle: Walk
					setMotion: MoveTo 274 131 self
				)
			)
			(5
				(man setPri: (man priority:) setMotion: MoveTo 246 125 self)
			)
			(6
				(man setPri: -1 setMotion: MoveTo 249 111 self)
			)
			(7
				(man setMotion: MoveTo 217 108 self)
			)
			(8
				(if (> global131 0)
					(gEgo setScript: musicScript)
				)
				(man setMotion: MoveTo 200 121 self)
			)
			(9
				(man setMotion: MoveTo 185 117)
				(door setCycle: End self)
			)
			(10
				(mouse init: setMotion: MoveTo 216 120 self)
			)
			(11
				(if (< global131 1)
					(gEgo setScript: musicScript)
				)
				(man setMotion: MoveTo 198 118 self)
			)
			(12
				(mouse observeControl: 254 setMotion: MoveTo 238 128)
				(man view: 76 setLoop: 4 cel: 0 setCycle: Fwd)
				(= cycles 5)
			)
			(13
				(man
					view: 83
					setLoop: -1
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 240 111 self
				)
			)
			(14
				(man setMotion: MoveTo 233 129 self)
				(mouseCage init:)
				(mouse observeBlocks: mouseCage setMotion: Wander)
			)
			(15
				(man
					view: 83
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 330 130 self
				)
			)
			(16
				(mouse ignoreBlocks: mouseCage setMotion: MoveTo 238 120)
				(cat init:)
				(man setMotion: MoveTo 270 130 self)
			)
			(17
				(mouse setMotion: MoveTo 210 125)
				(cat setAvoider: Avoid xStep: 2 setMotion: Chase mouse 20 self)
			)
			(18
				(mouse hide:)
				(cat
					posn: (- (cat x:) 11) (cat y:)
					setAvoider: 0
					setLoop: 5
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(19
				(mouse ignoreControl: -1 show: setMotion: MoveTo 148 119 self)
				(cat
					posn: (+ (cat x:) 11) (cat y:)
					ignoreControl: -1
					setLoop: 0
					setMotion: Follow mouse
				)
				(man ignoreControl: -1 setMotion: Follow cat)
			)
			(20
				(cat setMotion: MoveTo 148 119 self)
				(mouse dispose:)
			)
			(21
				(man setMotion: MoveTo 148 119 self)
				(cat dispose:)
			)
			(22
				(man hide:)
				(door setCycle: Beg self)
			)
			(23
				(gEgo setMotion: 0 setAvoider: 0 setCycle: Walk setLoop: -1)
				(= local0 0)
				(= global103 0)
			)
			(24
				(gGame setSpeed: global206)
				(gGlobalMGSound loop: -1)
				(rhymeBox dispose:)
				(proc0_12)
				(man dispose:)
				(if (== gScore gPossibleScore)
					(gEgo setAvoider: Avoid)
					(gEgo setScript: moveIntoOpen)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
					(if (== global208 0)
						(gGlobalMGSound play:)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local6 1)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound loop: 1 play: self)
				(smoke hide:)
				(rhymeBox init:)
				(rhymeBox open:)
			)
			(1
				(= local1
					(Display
						{There was a crooked man,}
						dsWIDTH
						320
						dsCOORD
						5
						5
						dsALIGN
						alLEFT
						dsFONT
						0
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
			)
			(2
				(= local2
					(Display
						{and he went a crooked mile,}
						dsWIDTH
						320
						dsCOORD
						5
						17
						dsALIGN
						alLEFT
						dsFONT
						0
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
			)
			(3
				(= local3
					(Display
						{He found a crooked sixpence}
						dsWIDTH
						320
						dsCOORD
						5
						29
						dsALIGN
						alLEFT
						dsFONT
						0
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
			)
			(4
				(= local4
					(Display
						{beside a crooked stile;}
						dsWIDTH
						320
						dsCOORD
						5
						41
						dsALIGN
						alLEFT
						dsFONT
						0
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
			)
			(5
				(Display 15 0 dsRESTOREPIXELS local1)
				(Display 15 0 dsRESTOREPIXELS local2)
				(Display 15 0 dsRESTOREPIXELS local3)
				(Display 15 0 dsRESTOREPIXELS local4)
				(Display
					{He bought a crooked cat,}
					dsWIDTH
					320
					dsCOORD
					5
					5
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(6
				(Display
					{which caught a crooked mouse,}
					dsWIDTH
					320
					dsCOORD
					5
					17
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(7
				(Display
					{And they all lived together}
					dsWIDTH
					320
					dsCOORD
					5
					29
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(8
				(Display
					{in a crooked little house.}
					dsWIDTH
					320
					dsCOORD
					5
					41
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance paceN of Script
	(properties)

	(method (cue)
		(man setMotion: MoveTo 270 147 paceS)
	)
)

(instance paceS of Script
	(properties)

	(method (cue)
		(man setMotion: MoveTo 270 169 paceN)
	)
)

(instance rhymeSound of Sound
	(properties
		number 16
		priority 10
	)
)

(instance doorSound of Sound
	(properties
		priority 10
	)
)

(instance man of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 83
			ignoreControl: -1
			posn: 270 147
			xStep: 2
			yStep: 1
			setCycle: Walk
			cycleSpeed: 0
		)
		(paceS cue:)
	)
)

(instance mouse of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 64
			xStep: 2
			yStep: 1
			ignoreControl: -1
			posn: 151 125
			setCycle: Walk
			cycleSpeed: 2
			moveSpeed: 1
		)
	)
)

(instance cat of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 76
			ignoreControl: -1
			setLoop: 0
			posn: 330 135
			xStep: 2
			yStep: 1
			setCycle: Fwd
			cycleSpeed: 0
			setMotion: Follow man 5
		)
	)
)

(instance smoke of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 127 posn: 74 11 setLoop: 2 setCycle: Fwd cycleSpeed: 3)
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 127
			setLoop: 0
			setCel: (if (== gPrevRoomNum 40) species else 0)
			cycleSpeed: 1
			posn: 160 117
		)
	)
)

(instance flower of View
	(properties
		x 11
		y 186
		view 300
		loop 1
		cel 1
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 58
			setLoop: 1
			setCel: 0
			posn: 219 95
			setPri: 15
			hide:
			stopUpd:
		)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 setLoop: 0 posn: 215 120 setPri: 14 hide: stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 10
			bottom: 65
			right: 213
			type: 4
			title: {Crooked Man}
			back: 2
		)
	)
)

(instance moveIntoOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: 0)
				(gEgo setMotion: DPath 262 130 228 127 200 148 self)
			)
			(1
				(proc0_14 197 148)
			)
		)
	)
)

(instance gotItSound of Sound ; UNUSED
	(properties
		number 2
		priority 10
	)
)

(instance mouseCage of Cage
	(properties)

	(method (init)
		(super init:)
		(self top: 107 bottom: 140 left: 208 right: 245)
	)
)

