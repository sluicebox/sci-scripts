;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Follow)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm021 0
)

(local
	local0
	local1
	local2
)

(instance rm021 of Rm
	(properties
		picture 21
		style 0
		horizon 95
		north 14
		south 28
		west 20
	)

	(method (init)
		(Load rsSOUND 43)
		(Load rsSOUND 17)
		(Load rsSOUND 44)
		(Load rsSOUND 41)
		(Load rsSOUND 31)
		(Load rsVIEW 79)
		(Load rsVIEW 81)
		(Load rsVIEW 78)
		(Load rsVIEW 128)
		(Load rsVIEW 37)
		(Load rsVIEW 300)
		(Load rsVIEW 54)
		(Load rsVIEW 39)
		(super init:)
		(= global207 0)
		(= global125 -1)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(14
				(= global125 5)
				(gEgo setPri: 5 x: (+ (/ (* (- (gEgo x:) 1) 65) 136) 1))
			)
			(20
				(= global125 5)
				(if (< (gEgo y:) 125)
					(gEgo
						setPri: 5
						y: (+ (/ (* (- (gEgo y:) 106) 10) 12) 96)
					)
				else
					(gEgo
						setPri: 5
						y: (+ (/ (* (- (gEgo y:) 130) 41) 56) 107)
					)
				)
			)
			(28
				(gEgo x: (+ (/ (* (- (gEgo x:) 177) 26) 20) 149))
			)
			(44
				(gEgo
					loop: 2
					x: (+ (/ (* (- (gEgo x:) 233) 18) 37) 273)
					y: 147
					edgeHit: EDGE_NONE
				)
				(self setScript: closeDoorScript)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(swingSet0 init: addToPic:)
		(swingSet1 init: addToPic:)
		(swingSet2 init: addToPic:)
		(gAddToPics
			add:
				flower
				((Clone flower) loop: 1 cel: 2 x: 86 y: 112)
				((Clone flower) loop: 1 cel: 2 x: 258 y: 156)
				((Clone flower) loop: 1 cel: 1 x: 151 y: 154)
				((Clone flower) loop: 1 cel: 2 x: 161 y: 154)
				((Clone flower) loop: 1 cel: 2 x: 192 y: 154)
				((Clone flower) loop: 1 cel: 0 x: 315 y: 156)
				((Clone flower) loop: 1 cel: 2 x: 314 y: 167)
				((Clone flower) loop: 2 cel: 2 x: 319 y: 169)
				((Clone flower) loop: 1 cel: 1 x: 315 y: 175)
				((Clone flower) loop: 1 cel: 2 x: 313 y: 180)
			eachElementDo: #init
			doit:
		)
		(proc0_10)
		(if (not [global675 21])
			(cond
				(global131
					(kid0 init: stopUpd:)
					(kid1 init:)
					(kid2 init:)
					(kid4 init: stopUpd:)
					(kid5 init:)
					(mother init:)
				)
				((not (proc0_11 54))
					(kid0 init: addToPic:)
					(kid1 init: addToPic:)
					(kid2 init: addToPic:)
					(kid4 init: addToPic:)
					(kid5 init: addToPic:)
					(mother init: addToPic:)
				)
				(else
					(kid0 init:)
					(kid1 init:)
					(kid2 init:)
					(kid4 init:)
					(kid5 init:)
					(mother init:)
				)
			)
		else
			(swing init: addToPic:)
			(= local1 1)
		)
		(if (and (== gPrevRoomNum 28) (not [global675 21]) (proc0_11 54))
			(= [global675 21] 1)
			(= global206 gSpeed)
			(switch global131
				(0
					(gGame setSpeed: 4)
				)
				(1
					(gGame setSpeed: 7)
				)
				(2
					(gGame setSpeed: 8)
				)
			)
			(mother setScript: rhymeScript)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 31)
						(== local2 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 31) (== local2 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 31) (== local2 1))
					(rhymeScript cycles: 1)
				)
				(if
					(and
						(& temp0 emSHIFT)
						(!= local1 1)
						(proc0_16 event 241 131 257 169)
					)
					(LookAt mother)
					(gCurRoom setScript: talkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(if (and (== (gEgo onControl: 1) 16384) (!= script openDoorScript))
			(self setScript: openDoorScript)
		)
		(super doit:)
		(if (> (gEgo distanceTo: mother) 30)
			(= global108 0)
		)
		(if
			(and
				(== gPrevRoomNum 28)
				(not [global675 21])
				(not global108)
				(< (gEgo distanceTo: mother) 30)
			)
			(= global108 1)
			(LookAt mother)
			(gCurRoom setScript: talkScript)
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
				(gCurRoom newRoom: 44)
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
				(gGlobalMGSound stop:)
				(door setCycle: Beg self)
				(doorSound number: 43 loop: 1 play:)
			)
			(1
				(door stopUpd:)
				(doorSound number: 44 loop: 1 play: self)
			)
			(2
				(= cycles 5)
			)
			(3
				(HandsOn)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
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
				(HandsOff)
				(if (not global131)
					(gEgo stopUpd:)
					(door stopUpd:)
					(mother stopUpd:)
				)
				(itemVisual init: hide: stopUpd:)
				(= cycles 2)
			)
			(1
				(= global103 1)
				(= local1 1)
				(if global131
					(mother setLoop: 6 setCycle: Fwd)
				)
				(itemBalloon init: setCel: 0)
				(RedrawCast)
				(Display
					{Can you\nbring me\nsome broth\nfor my\nchildren?}
					dsWIDTH
					100
					dsCOORD
					145
					66
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(rhymeSound number: 41 loop: 1 play: self)
			)
			(2
				(mother setCel: 0)
				(itemBalloon setCel: 1)
				(itemVisual show:)
				(= seconds global121)
			)
			(3
				(itemVisual dispose:)
				(itemBalloon dispose:)
				(= global103 0)
				(= local1 0)
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
				(= global209 1)
				(= global103 1)
				(= local1 1)
				(HandsOff)
				(gEgo setMotion: MoveTo (mother x:) (+ (mother y:) 8) self)
			)
			(1
				(proc0_18)
				(mother view: 81 posn: 248 158 setLoop: 7 setCel: 0)
				(kid4
					view: 81
					posn: 64 189
					setLoop: 4
					setCycle: Walk
					setPri: -1
					cycleSpeed: 1
					moveSpeed: 1
				)
				(kid5
					view: 81
					posn: 73 160
					setLoop: 5
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
				)
				(swing init: addToPic:)
				(gEgo setAvoider: Avoid setMotion: MoveTo 296 179 self)
			)
			(2
				(gEgo setAvoider: 0 setLoop: 3 stopUpd:)
				(kid1
					view: 81
					setLoop: 1
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
				)
				(kid2
					view: 81
					setLoop: 2
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
				)
				(= cycles 2)
			)
			(3
				(kid0
					view: 81
					setLoop: 0
					setAvoider: Avoid
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
				)
				(mother setCel: 1)
				(supperBalloon init:)
				(RedrawCast)
				(supper init:)
				(= seconds global122)
			)
			(4
				(supper dispose:)
				(supperBalloon dispose:)
				(mother setCel: 0)
				(if (> global131 0)
					(RedrawCast)
					(RedrawCast)
					(gEgo setScript: musicScript)
				)
				(kid0 setAvoider: 0 setMotion: MoveTo 250 170 self)
				(kid1 setMotion: Follow kid2 20)
				(kid2 setMotion: Follow kid0 20)
				(kid4 setMotion: Follow kid1 20)
				(kid5 setMotion: Follow kid4 20)
				(mother
					view: 78
					posn: 252 158
					setLoop: 6
					setCel: 0
					xStep: 3
					yStep: 2
					setPri: (+ (mother priority:) 1)
					stopUpd:
				)
			)
			(5
				(kid0
					setAvoider: 0
					ignoreActors: 1
					setMotion: MoveTo 265 170 self
				)
				(kid2 setMotion: MoveTo 250 170)
			)
			(6
				(if (< global131 1)
					(gEgo setScript: musicScript)
				)
				(kid0
					view: 78
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 271 159 self
				)
			)
			(7
				(kid0 setLoop: 8 setCel: 0)
				(mother setCel: 0)
				(RedrawCast)
				(mother setCel: 1)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(mother setCel: 2)
				(kid0
					view: 78
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 271 150 self
				)
			)
			(8
				(mother setCel: 3)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(kid0 setLoop: 8 setCel: 1)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(mother setCel: 0)
				(RedrawCast)
				(RedrawCast)
				(kid0 setLoop: 8 setCel: 2)
				(= seconds 2)
			)
			(9
				(kid0
					setLoop: 0
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 280 138
				)
				(kid1 setMotion: MoveTo 250 170)
				(kid2
					setAvoider: 0
					ignoreActors: 1
					setMotion: MoveTo 265 170 self
				)
			)
			(10
				(kid0 setPri: 4 setMotion: MoveTo 255 130)
				(kid2
					view: 78
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 272 159 self
				)
			)
			(11
				(kid0 dispose:)
				(kid2 setLoop: 8 setCel: 6)
				(mother setCel: 0)
				(RedrawCast)
				(mother setCel: 1)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(mother setCel: 2)
				(kid2
					view: 78
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 271 150 self
				)
			)
			(12
				(mother setCel: 3)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(kid2 setLoop: 8 setCel: 7)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(mother setCel: 0)
				(RedrawCast)
				(RedrawCast)
				(kid2 setLoop: 8 setCel: 8)
				(= seconds 2)
			)
			(13
				(kid2
					setLoop: 2
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 280 138
				)
				(kid4 setMotion: MoveTo 250 170)
				(kid1
					setAvoider: 0
					ignoreActors: 1
					setMotion: MoveTo 265 170 self
				)
			)
			(14
				(kid2 setPri: 4 setMotion: MoveTo 255 130)
				(kid1
					view: 78
					setLoop: 1
					setCycle: Walk
					illegalBits: 0
					setMotion: MoveTo 271 158 self
				)
			)
			(15
				(kid2 dispose:)
				(kid1 setLoop: 8 setCel: 3)
				(mother setCel: 0)
				(RedrawCast)
				(mother setCel: 1)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(mother setCel: 2)
				(kid1
					view: 78
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 271 150 self
				)
			)
			(16
				(mother setCel: 3)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(kid1 setLoop: 8 setCel: 4)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(mother setCel: 0)
				(RedrawCast)
				(RedrawCast)
				(kid1 setLoop: 8 setCel: 5)
				(= seconds 2)
			)
			(17
				(kid1
					setLoop: 1
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 280 138
				)
				(kid4
					setAvoider: 0
					ignoreActors: 1
					setMotion: MoveTo 265 170 self
				)
				(kid5 setMotion: MoveTo 250 170)
			)
			(18
				(kid1 setPri: 4 setMotion: MoveTo 255 130)
				(kid4
					view: 78
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 271 159 self
				)
			)
			(19
				(kid1 dispose:)
				(kid4 setLoop: 8 setCel: 9)
				(mother setCel: 0)
				(RedrawCast)
				(mother setCel: 1)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(mother setCel: 2)
				(kid4
					view: 78
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 271 150 self
				)
			)
			(20
				(mother setCel: 3)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(kid4 setLoop: 8 setCel: 10)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(mother setCel: 0)
				(RedrawCast)
				(RedrawCast)
				(kid4 setLoop: 8 setCel: 11)
				(= seconds 2)
			)
			(21
				(kid4
					setLoop: 4
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 280 138
				)
				(kid5
					setAvoider: 0
					ignoreActors: 1
					setMotion: MoveTo 265 170 self
				)
			)
			(22
				(kid4 setPri: 4 setMotion: MoveTo 255 130)
				(kid5
					view: 78
					setLoop: 5
					setCycle: Walk
					illegalBits: 0
					setMotion: MoveTo 273 159 self
				)
			)
			(23
				(kid4 dispose:)
				(kid5 setLoop: 8 setCel: 12)
				(mother setCel: 0)
				(RedrawCast)
				(mother setCel: 1)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(mother setCel: 2)
				(kid5
					view: 78
					setLoop: 5
					setCycle: Walk
					setMotion: MoveTo 271 150 self
				)
			)
			(24
				(mother setCel: 3)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(kid5 setLoop: 8 setCel: 13)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(RedrawCast)
				(mother setCel: 0)
				(RedrawCast)
				(RedrawCast)
				(kid5 setLoop: 8 setCel: 14)
				(= seconds 2)
			)
			(25
				(kid5
					setLoop: 5
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 280 138 self
				)
			)
			(26
				(kid5 setPri: 4 setMotion: MoveTo 255 130 self)
			)
			(27
				(kid5 dispose:)
				(mother
					view: 79
					posn: 246 158
					setLoop: 7
					setCel: 2
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 251 170 self
				)
			)
			(28
				(mother view: 79 setLoop: 8 setMotion: MoveTo 275 170 self)
			)
			(29
				(mother
					view: 78
					illegalBits: 0
					setLoop: 7
					setMotion: MoveTo 280 138 self
				)
			)
			(30
				(mother setPri: 4 setLoop: 7 setMotion: MoveTo 255 130 self)
			)
			(31
				(mother hide:)
				(door setCel: 0)
				(gEgo setMotion: 0 setCycle: Walk setLoop: -1)
				(= local0 0)
				(= global103 0)
			)
			(32
				(gGame setSpeed: global206)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(rhymeBox dispose:)
				(proc0_12)
				(mother dispose:)
				(if (== gScore gPossibleScore)
					(gEgo setAvoider: Avoid)
					(proc0_14 210 170)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local2 1)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound number: 31 loop: 1 play: self)
				(rhymeBox init:)
				(rhymeBox open:)
			)
			(1
				(Display
					{There was an old woman}
					dsWIDTH
					300
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
			(2
				(Display
					{     Who lived in a shoe.}
					dsWIDTH
					300
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
			(3
				(Display
					{She had so many children}
					dsWIDTH
					300
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
			(4
				(Display
					{     She didn't know what to do.}
					dsWIDTH
					300
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
			(5
				(Display
					{She gave them some broth}
					dsWIDTH
					300
					dsCOORD
					5
					55
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
					{     Without any bread.}
					dsWIDTH
					300
					dsCOORD
					5
					67
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
					{She whipped them all soundly}
					dsWIDTH
					300
					dsCOORD
					5
					79
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
					{     And put them to bed.}
					dsWIDTH
					300
					dsCOORD
					5
					91
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

(instance rhymeSound of Sound
	(properties
		number 31
		priority 10
	)
)

(instance doorSound of Sound
	(properties
		priority 10
	)
)

(instance mother of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 79
			ignoreControl: -1
			posn: 251 158
			setLoop: 6
			setCel: 0
			xStep: 1
			yStep: 1
			stopUpd:
		)
	)
)

(instance kid0 of Act
	(properties)

	(method (init)
		(super init:)
		(if (and (== global111 54) (== gPrevRoomNum 28))
			(self
				view: 79
				posn: 180 153
				setLoop: 3
				setCel: 0
				ignoreControl: -1
				ignoreActors: 1
				stopUpd:
			)
			(door setCel: (door lastCel:))
		else
			(self view: 79 posn: 110 120 setLoop: 0 cycleSpeed: 3 setCycle: Fwd)
		)
	)
)

(instance kid1 of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 79 posn: 93 178 setLoop: 1 setCycle: Fwd cycleSpeed: 3)
	)
)

(instance kid2 of Act
	(properties)

	(method (init)
		(super init:)
		(if (and (== global111 54) (== gPrevRoomNum 28))
			(self
				view: 81
				setLoop: 6
				setCel: 0
				ignoreControl: -1
				ignoreActors: 1
				posn: 141 154
				stopUpd:
			)
		else
			(self
				view: 79
				setPri: 13
				setLoop: 2
				setCycle: Fwd
				cycleSpeed: 3
				ignoreControl: -1
				ignoreHorizon: 1
				posn: 221 57
			)
		)
	)
)

(instance kid4 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 79
			setPri: 15
			posn: 62 178
			setLoop: 4
			setCycle: Fwd
			cycleSpeed: 3
			ignoreControl: -1
			ignoreActors: 1
		)
	)
)

(instance kid5 of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 79 setLoop: 5 setCycle: Fwd cycleSpeed: 3 posn: 65 160)
	)
)

(instance supper of View
	(properties)

	(method (init)
		(super init:)
		(self view: 128 posn: 168 117 setLoop: 1 setCel: 0 setPri: 15 stopUpd:)
	)
)

(instance supperBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 37 posn: 180 133 setLoop: 0 setCel: 0 setPri: 14 stopUpd:)
	)
)

(instance swingSet0 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 128 posn: 54 172 setLoop: 0 setCel: 0 stopUpd:)
	)
)

(instance swingSet1 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 128 setPri: 14 posn: 65 135 setLoop: 0 setCel: 1 stopUpd:)
	)
)

(instance swingSet2 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 128 posn: 75 148 setLoop: 0 setCel: 2 stopUpd:)
	)
)

(instance swing of View
	(properties)

	(method (init)
		(super init:)
		(self view: 128 posn: 67 154 setLoop: 0 setCel: 3 stopUpd:)
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 128
			setLoop: 3
			setCel: (if (== gPrevRoomNum 44) species else 0)
			cycleSpeed: 1
			ignoreActors: 1
			posn: 298 140
		)
	)
)

(instance flower of PV
	(properties
		y 154
		x 182
		view 300
		loop 1
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self view: 54 setLoop: 1 setCel: 0 posn: 198 100 setPri: 15 stopUpd:)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 posn: 195 125 setPri: 14 stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 10
			bottom: 115
			right: 216
			type: 4
			title: {Old Woman in the Shoe}
			back: 11
		)
	)
)

