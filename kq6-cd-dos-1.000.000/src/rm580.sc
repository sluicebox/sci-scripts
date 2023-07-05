;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Inset)
(use Conversation)
(use Scaler)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm580 0
)

(local
	local0
	local1
)

(instance rm580Messager of Kq6Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(59 gNarrator)
					(60 gNarrator)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance fireSound of Sound
	(properties
		number 560
		loop -1
	)
)

(instance rainSound of Sound
	(properties
		number 567
		loop -1
	)
)

(instance fx0 of Sound
	(properties)
)

(instance fx1 of Sound
	(properties)
)

(instance fx2 of Sound
	(properties)
)

(instance rm580 of KQ6Room
	(properties
		noun 3
		picture 580
		south 550
		west 560
		autoLoad 0
	)

	(method (init)
		(super init: &rest)
		(= local1 gMessager)
		(= gMessager rm580Messager)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 89 165 42 185 0 185 0 0 319 0 319 189 249 189 208 167 261 154 255 120 213 119 166 119 126 122 56 138 49 153
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 214 129 206 147 137 147 123 129 151 130 174 121 185 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 153 158 127 171 82 156 106 147 144 149
					yourself:
				)
		)
		(if (and (not (IsFlag 25)) (not (IsFlag 74)))
			(= local0 1)
		)
		(if (and (IsFlag 25) (not (IsFlag 14)) (not (IsFlag 74)))
			(SetFlag 14)
			(= local0 2)
		)
		(if local0
			(gTheIconBar
				enable:
				disable: 0 1 2 3 4 5 6
				height: -100
				activateHeight: -100
			)
			(Cursor showCursor: 0)
			(gGlobalSound number: 569 loop: -1 flags: 1 play: hold: 10)
			(gGlobalSound2 stop:)
			(if (== local0 1)
				(druid init: setScale: Scaler 100 70 190 112 setPri: 14)
				(druid2 setScale: Scaler 100 70 190 112 init:)
			)
			(druid3 init: setScale: Scaler 100 70 190 112)
			(druid4
				init:
				setScale: Scaler 100 70 190 112
				ignoreActors: 1
				stopUpd:
			)
			(headDruid init: setScale: Scaler 100 70 190 112)
			(fire init: setCycle: RandCycle)
			(smoke init:)
			(fireSound play:)
			(rope init: stopUpd:)
			(cage init: setPri: 14 ignoreActors: 1 stopUpd:)
			(cageRope init: setPri: 14 ignoreActors: 1 stopUpd:)
		else
			(gGlobalSound number: 570 loop: -1 flags: 1 play: hold: 10)
			(fire init: setLoop: 2 posn: 167 137 setCycle: RandCycle)
			(cage init: setPri: 12 ignoreActors: 1 addToPic:)
			(cageRope init: setPri: 12 ignoreActors: 1 addToPic:)
		)
		(bonfire init:)
		(circleOfStones init:)
		(trees init:)
		(gEgo init: setScale: Scaler 100 70 190 112)
		(if (== gPrevRoomNum 560)
			(gEgo posn: 9 187)
		else
			(gEgo posn: 164 212)
		)
		(gGame handsOff:)
		(self setScript: egoEnters)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound fade:)
		(= gMessager local1)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 939)
		(Palette palSET_INTENSITY 0 255 100)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== local0 2)
						(gEgo
							view: 5806
							posn: 148 235
							setLoop: 0
							setMotion: MoveTo 162 160 self
							setPri: 14
							setSpeed: 3
							setCycle: Walk
						)
					)
					((== gPrevRoomNum 560)
						(gEgo setMotion: MoveTo 162 (gEgo y:) self)
					)
					(else
						(gEgo setMotion: MoveTo 162 170 self)
					)
				)
			)
			(1
				(switch local0
					(0
						(gGame handsOn:)
						(self dispose:)
					)
					(1
						(if (== gPrevRoomNum 560)
							(gEgo setMotion: MoveTo 162 170 self)
						else
							(= ticks 1)
						)
					)
					(2
						(gCurRoom setScript: meetDruidsTwo)
					)
				)
			)
			(2
				(gCurRoom setScript: meetDruidsOne)
			)
		)
	)
)

(instance getEmbers of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 208 130 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(gEgo
					normal: 0
					view: 5803
					setLoop: 0
					cel: 0
					cycleSpeed: 10
					posn: 206 131
					setCycle: End self
				)
			)
			(3
				(gEgo reset: 5 posn: 211 129)
				(= cycles 2)
			)
			(4
				(if (not (SetFlag 140))
					(gGame givePoints: 1)
				)
				(cond
					(
						(and
							(& (= temp1 ((gInventory at: 11) state:)) $0004) ; skull
							(not (& temp1 $0001))
							(not (& temp1 $0002))
						)
						(gMessager say: 4 51 13 1 self) ; "Alexander exchanges the embers in his skull for more red-hot embers from the fire."
					)
					((and (& temp1 $0004) (or (& temp1 $0001) (& temp1 $0002)))
						(gMessager say: 4 51 14 1 self) ; "Alexander exchanges the embers in the skull for more red-hot embers from the fire, being careful not to disturb the rest of the skull's contents."
					)
					(else
						(gMessager say: 4 51 11 1 self) ; "Alexander scoops up some of the red-hot embers in the ancient human skull."
					)
				)
			)
			(5
				(gEgo reset: 2)
				(= temp0 (gInventory at: 11)) ; skull
				((ScriptID 0 4) setReal: temp0 0 5 0) ; emberTimer
				(temp0
					setCursor: 990 0 9
					loop: 0
					cel: 10
					state: (| (temp0 state:) $000c)
				)
				((temp0 cursor:) loop: 0 cel: 9)
				(gGame setCursor: (temp0 cursor:) handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance meetDruidsOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 14)
				(gMessager say: 1 0 1 1 self) ; "Alexander is frozen at the spectacle before him; robed figures are gathered around a bonfire. Some mystical ceremony is taking place, but as to its purpose, Alexander has no clue."
			)
			(1
				(gMessager say: 1 0 1 2 self) ; "Brothers, look!"
			)
			(2
				(gMessager say: 1 0 1 3 self) ; "Uh, oh! Alexander's been seen!"
			)
			(3
				(druid
					setPri: 14
					setCycle: Walk
					setSpeed: 0
					xStep: 6
					setMotion:
						MoveTo
						(- (gEgo x:) 25)
						(+ (gEgo y:) 3)
						self
					ignoreActors: 1
					illegalBits: 0
				)
				(druid2
					setCycle: Walk
					setSpeed: 0
					xStep: 6
					setMotion:
						MoveTo
						(+ (gEgo x:) 24)
						(+ (gEgo y:) 4)
						self
					ignoreActors: 1
					illegalBits: 0
				)
			)
			(4 0)
			(5
				(druid hide:)
				(druid2 hide:)
				(gEgo
					view: 554
					normal: 0
					setPri: 14
					setLoop: 0
					setCel: 0
					posn: (- (gEgo x:) 2) (gEgo y:)
					setCycle: End self
				)
			)
			(6
				(gEgo view: 5806 setLoop: 0 setCycle: Walk)
				(gCurRoom setScript: continueDruids)
			)
		)
	)
)

(instance meetDruidsTwo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(druid
					view: 553
					posn: 0 0
					init:
					setPri: 14
					ignoreActors: 1
					illegalBits: 0
					hide:
				)
				(druid2
					view: 553
					posn: 0 0
					init:
					ignoreActors: 1
					illegalBits: 0
					hide:
				)
				(SetFlag 14)
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 1 1 self) ; "Alexander is frozen at the spectacle before him; robed figures are gathered around a bonfire. Some mystical ceremony is taking place, but as to its purpose, Alexander has no clue."
			)
			(2
				(gMessager say: 1 0 8 1 self) ; "We found a trespasser on the beach, Arch Druid!"
			)
			(3
				(gMessager say: 1 0 8 2 self) ; "Uh, oh! Arch Druid? Now what has Alexander wandered into?"
			)
			(4
				(gCurRoom setScript: continueDruids)
			)
		)
	)
)

(instance continueDruids of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 1 4 self) ; "This must be the foreigner we were warned about. How appropriate that he should come during our Rain Festival. Place him in the sacrificial cage!"
			)
			(1
				(gMessager say: 1 0 1 5 self) ; "(SHOUTING) Wait! I must rescue the princess!"
			)
			(2
				(gMessager say: 1 0 1 6 self) ; "There's an ancient Druid saying: 'A man who would save others must first save himself!'"
			)
			(3
				(gGlobalSound hold: 20)
				(cage signal: (| (cage signal:) $6000))
				(= cycles 2)
			)
			(4
				(gEgo setMotion: MoveTo 177 158 self)
			)
			(5
				(UnLoad 128 554)
				(gEgo
					view: 588
					setLoop: 0
					cel: 0
					setSpeed: 3
					setPri: (- (cage priority:) 1)
					posn: (- (gEgo x:) 18) (+ (gEgo y:) 2)
					setCycle: End self
				)
			)
			(6
				(gEgo view: 581 setLoop: 1 setPri: -1 setCycle: End self)
			)
			(7
				(cage view: 5807 setLoop: 0 cel: 0 posn: 146 124 setPri: 14)
				(cageRope view: 5807 setLoop: 1 cel: 0 setPri: 14)
				(gEgo view: 553 hide:)
				(UnLoad 128 580)
				(UnLoad 128 581)
				(druid
					show:
					posn: (- (gEgo x:) 12) (- (gEgo y:) 4)
					setLoop: -1
					setCycle: Walk
				)
				(druid2
					show:
					posn: (- (gEgo x:) 37) (- (gEgo y:) 10)
					setLoop: -1
					setCycle: Walk
				)
				(= cycles 2)
			)
			(8
				(gMessager say: 1 0 1 7 self) ; "Alexander is pushed into the confining wicker cage."
			)
			(9
				(druid setMotion: MoveTo (druid x:) (+ (druid y:) 10) self)
				(druid2 setMotion: MoveTo 222 180 self)
			)
			(10
				(druid setMotion: MoveTo 85 178 self)
			)
			(11 0)
			(12
				(headDruid view: 587 setLoop: 0 cel: 0 setCycle: End self)
			)
			(13
				(headDruid view: 5808)
				(druid
					setLoop: 4
					cel: 3
					setLoop: -1
					setPri: (+ (cage priority:) 1)
				)
				(druid2 setLoop: 4 cel: 3 setLoop: -1)
				(druid3
					setPri: (- (rope priority:) 1)
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 194 131 self
					ignoreActors: 1
				)
			)
			(14
				(druid5
					init:
					setLoop: -1
					setScale: Scaler 100 70 190 112
					setCycle: Walk
					setMotion: MoveTo 224 130 self
				)
			)
			(15
				(fx0 number: 563 loop: -1 play:)
				(druid3
					view: 5804
					setLoop: 0
					posn: 208 133
					setCycle: Fwd
					setPri: -1
				)
				(rope dispose:)
				(druid5 dispose:)
				(cageRope setCel: 1)
				(cage posn: 147 124)
				(= cycles 5)
			)
			(16
				(cageRope setCel: 2)
				(cage posn: 152 117)
				(= cycles 5)
			)
			(17
				(cageRope setCel: 3)
				(cage posn: 166 107)
				(= cycles 5)
			)
			(18
				(cageRope dispose:)
				(cage
					view: 5801
					setPri: 14
					setCel: 0
					setLoop: 0
					cycleSpeed: 5
					posn: 170 54
					setCycle: End self
				)
			)
			(19
				(fx0 stop:)
				(UnLoad 128 5807)
				(cage cel: 0 setCycle: End self)
			)
			(20
				(druid3 setCycle: 0 setPri: 12 stopUpd:)
				(cage setLoop: 1 cel: 6 setCycle: End self)
			)
			(21
				(cage cel: 0 setCycle: End self)
			)
			(22
				(cage view: 5802 setLoop: 0 setCel: 0)
				(UnLoad 128 5801)
				(= cycles 2)
			)
			(23
				(gMessager say: 1 0 1 8 self) ; "And the cage is swung out over the bonfire!"
			)
			(24
				(cage setPri: 12 stopUpd:)
				(smoke dispose:)
				(gCurRoom setInset: cageInset)
				(self dispose:)
			)
		)
	)
)

(instance inTheCage of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gGlobalSound hold: 30)
				(inEgo view: 583 setLoop: 0 cel: 1)
				(= ticks 12)
			)
			(2
				(inEgo stopUpd:)
				(gMessager say: 1 0 2 0 self) ; "Alexander starts to feel a little warm."
			)
			(3
				(= seconds 5)
			)
			(4
				(gGlobalSound hold: 0)
				(inEgo cel: 2)
				(= ticks 12)
			)
			(5
				(inEgo stopUpd:)
				(gMessager say: 1 0 3 0 self) ; "The bottom of the cage is getting uncomfortably hot."
			)
			(6
				(= seconds 3)
			)
			(7
				(inEgo cel: 3)
				(= seconds 2)
			)
			(8
				(if (not global161)
					(gMessager say: 1 0 4 0 self) ; "Alexander is getting REALLY hot!"
				else
					(++ state)
					(gMessager say: 1 0 7 0 self) ; "Mercifully, Alexander passes out from the heat before the first tongues of flame ignite the wicker."
				)
			)
			(9
				(gMessager say: 1 0 7 0 self) ; "Mercifully, Alexander passes out from the heat before the first tongues of flame ignite the wicker."
			)
			(10
				(gGlobalSound number: 561 loop: 1 play: self)
				(inEgo setLoop: 1 cel: 0 setCycle: End)
			)
			(11
				(for ((= temp0 100)) (>= temp0 0) ((-= temp0 10))
					(Palette palSET_INTENSITY 0 255 temp0)
				)
				(= cycles 1)
			)
			(12
				(cageInset dispose: 0)
				(= cycles 2)
			)
			(13
				(gCurRoom drawPic: 98)
				(gCast eachElementDo: #dispose)
				(= cycles 2)
			)
			(14
				(Palette palSET_INTENSITY 0 255 100)
				(gTheIconBar height: 0 activateHeight: 0 enable: 6)
				(Cursor showCursor: 1)
				(if (== gAct 5)
					(EgoDead 11) ; "Feeling hot and sweaty? Try a shower!"
				else
					(EgoDead 10) ; "That was a bit too hot to handle! Alexander should have been better prepared."
				)
			)
		)
	)
)

(instance makeRain of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 50])
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gGlobalSound hold: 30)
				(inEgo cel: 1)
				(= ticks 12)
			)
			(2
				(inEgo stopUpd:)
				(gMessager say: 1 0 2 0 self) ; "Alexander starts to feel a little warm."
			)
			(3
				(= seconds 5)
			)
			(4
				(gGlobalSound hold: 0)
				(inEgo cel: 2)
				(= ticks 12)
			)
			(5
				(inEgo stopUpd:)
				(gMessager say: 1 0 3 0 self) ; "The bottom of the cage is getting uncomfortably hot."
				(= seconds 5)
			)
			(6
				(gMessager say: 1 0 6 0 self) ; "This cage is REALLY hot!"
			)
			(7
				(gMessager say: 1 0 9 1) ; "Fire in the cage!"
				(fx0 number: 562 loop: -1 play:)
				(inFlame show: setCycle: RandCycle)
				(= seconds 2)
			)
			(8
				(fx1 number: 568 loop: 1 play:)
				(inEgo
					view: 585
					setLoop: 1
					cel: 0
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(9
				(inEgo setCycle: End self)
			)
			(10
				(inFlame dispose:)
				(fx0 stop:)
				(inEgo setCycle: End self)
			)
			(11
				(gEgo put: 5 580) ; clothes
				(if (and (IsFlag 112) (not (gEgo has: 4))) ; hair
					(gMessager say: 1 0 15 1 self) ; "Alexander pulls out Beauty's old slave clothes, desperate to beat out the flames! As he does so, a strand of Beauty's hair that had been caught in the mantle comes free of the clothes."
					(gGame givePoints: 1)
					(gEgo get: 4) ; hair
				else
					(gMessager say: 1 0 9 2 self) ; "Alexander pulls out Beauty's old slave clothes, desperate to beat out the flames!"
				)
			)
			(12
				(inEgo view: 583 setLoop: 0 cel: 2 setCycle: 0)
				(UnLoad 128 585)
				(= cycles 2)
			)
			(13
				(gMessager say: 1 0 9 3 self) ; "The flame is extinguished, but the clothes themselves burn to cinders. Alexander won't be able to keep the cage from igniting for long!"
			)
			(14
				(= seconds 2)
			)
			(15
				(fx0 number: 520 loop: -1 play:)
				(inEgo
					view: 582
					setLoop: 7
					cel: 0
					cycleSpeed: 15
					setCycle: Osc 2 self
				)
			)
			(16
				(inEgo setCycle: 0 stopUpd:)
				(gMessager say: 1 0 9 4 self) ; "The heat and movement must have jarred something...."
			)
			(17
				(= seconds 2)
			)
			(18
				(inEgo setCycle: Osc 2 self)
			)
			(19
				(inEgo setCycle: 0 stopUpd:)
				(gMessager say: 1 0 9 5 self) ; "Something that Alexander's carrying is starting to jiggle around!"
			)
			(20
				(= seconds 2)
			)
			(21
				(inEgo setCycle: Osc 2 self)
			)
			(22
				(inEgo setCycle: 0 stopUpd:)
				(gMessager say: 1 0 9 6 self) ; "Egad! Something's REALLY percolating!"
			)
			(23
				(gGame givePoints: 2)
				(inEgo view: 5821 setLoop: 0 cel: 0 setCycle: End self)
			)
			(24
				(inEgo view: 582 setLoop: 5 cycleSpeed: 2 setCycle: End self)
			)
			(25
				(inEgo setCycle: End self)
			)
			(26
				(inEgo setCycle: End self)
			)
			(27
				(inEgo setCycle: End self)
			)
			(28
				(inEgo cel: 0 setCycle: End self)
			)
			(29
				(inEgo setLoop: 6 setCycle: End self)
			)
			(30
				(inEgo setCycle: 0 stopUpd:)
				(gMessager say: 1 0 9 7 self) ; "The water in Alexander's lamp is hot! It's just about...."
			)
			(31
				(gMessager say: 1 0 9 8 self) ; "BOILING!!!!"
			)
			(32
				(fx1 number: 565 loop: -1 play:)
				(inBillow show: setCycle: End self)
			)
			(33
				(inBillow setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(34
				(Palette palSET_FROM_RESOURCE 580)
				(= cycles 3)
			)
			(35
				(fx0 stop:)
				(fx1 stop:)
				(gGlobalSound fade:)
				(fx2 number: 566 loop: 1 play:)
				(Palette palSET_FROM_RESOURCE 5801)
				(= seconds 2)
			)
			(36
				(fx2 play:)
				(Palette palSET_FROM_RESOURCE 580)
				(= cycles 3)
			)
			(37
				(Palette palSET_FROM_RESOURCE 5801)
				(= cycles 10)
			)
			(38
				(fx2 play:)
				(Palette palSET_FROM_RESOURCE 580)
				(= cycles 3)
			)
			(39
				(Palette palSET_FROM_RESOURCE 5801)
				(= cycles 30)
			)
			(40
				(gMessager say: 1 0 9 9 self) ; "Alexander feels a drop. It starts to rain!"
			)
			(41
				(rainSound play:)
				(fireSound stop:)
				(= cycles 2)
			)
			(42
				(for ((= temp0 100)) (>= temp0 0) ((-- temp0))
					(Palette palSET_INTENSITY 0 255 temp0)
				)
				(= cycles 1)
			)
			(43
				(cageInset dispose:)
				(druid3 dispose:)
				(druid4 dispose:)
				(smoke dispose:)
				(headDruid posn: (headDruid x:) (headDruid y:) 1000)
				(druid posn: (druid x:) (druid y:) 1000)
				(druid2 posn: (druid2 x:) (druid2 y:) 1000)
				(fire posn: (fire x:) (fire y:) 1000)
				(gEgo posn: (gEgo x:) (gEgo y:) 1000)
				(cage posn: (cage x:) (cage y:) 1000)
				(gCurRoom drawPic: 98)
				(= cycles 2)
			)
			(44
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 3)
			)
			(45
				(fx2 play:)
				(= seconds 2)
			)
			(46
				(rainSound play:)
				(gMessager say: 1 0 9 10 self) ; "That man is a powerful nature wizard! By the sacred oak, let him DOWN!"
				(SetFlag 74)
			)
			(47
				(= seconds 3)
			)
			(48
				(gCurRoom drawPic: 98 12)
				(Message msgGET 580 1 0 9 11 @temp1) ; "Later, after a short but furious thunderstorm...."
				(Display @temp1 dsCOORD 82 85 dsCOLOR 14 dsFONT 0)
				(= cycles 1)
			)
			(49
				(rainSound stop:)
				(= cycles 1)
			)
			(50
				(gGlobalSound number: 570 loop: -1 play:)
				(= seconds 5)
			)
			(51
				(gCurRoom drawPic: 580 11)
				(cage
					view: 580
					loop: 0
					cel: 0
					ignoreActors: 1
					ignoreHorizon: 1
					posn: 147 124 0
					setPri: 12
					addToPic:
				)
				(cageRope
					view: 580
					init:
					loop: 1
					cel: 0
					ignoreHorizon: 1
					ignoreActors: 1
					posn: 170 54
					setPri: 12
					addToPic:
				)
				(fire posn: 167 137 0 setLoop: 2)
				(gEgo
					reset: 1
					setScale: Scaler 100 70 190 112
					posn: 131 135 0
				)
				(headDruid posn: (headDruid x:) (headDruid y:) 0)
				(druid posn: (druid x:) (druid y:) 0)
				(druid2 posn: (druid2 x:) (druid2 y:) 0)
				(= cycles 2)
			)
			(52
				(druidConv
					add: -1 1 0 10 1 ; "I must apologize for our rude welcoming committee. We've been feeling inhospitable ever since the Winged Ones stole our sacred miniature oak tree."
					add: -1 1 0 10 2 ; "Besides, Vizier Alhazred sent a message that we were to watch out for a highly-dangerous foreign assassin. I assume you ARE the one he meant."
					add: -1 1 0 10 3 ; "I'm sure I'm precisely who he meant. I assure you, I mean to harm no one--unless that person threatens the princess. I'm sorry to have disrupted your ceremony, but I'm running out of time."
					add: -1 1 0 10 4 ; "What is it that you seek?"
					add: -1 1 0 10 5 ; "The Oracle on the Isle of the Sacred Mountain told me I should speak to you about the Realm of the Dead. She told me of two souls in unrest there that I might be able to free."
					add: -1 1 0 10 6 ; "Free souls in the Realm of the Dead? You're mad!"
					add: -1 1 0 10 7 ; "The souls might be able to help me on my mission to save the princess. It's imperative that I do everything I can. The risks are not important."
					add: -1 1 0 10 8 ; "No? And yet getting yourself killed will hardly help the princess. <sigh> But I will tell you what I know."
					add: -1 1 0 10 9 ; "Legend has it that it is the right of any human to challenge the Lord of the Dead in order to save his own life or the life of another already passed. But the knowledge of how to do this was lost centuries ago."
					add: -1 1 0 10 10 ; "I have only heard of one who tried it--a young knight who came to the Land of the Green Isles from a distant land long ago. According to the story, he was determined to challenge the Lord of the Dead for the soul of his dead lover."
					add: -1 1 0 10 11 ; "It is said that he tamed the Lord of the Dead's horse, a black-winged, demon-hearted beast named Night Mare. Night Mare sometimes flies to the human world to feed on certain noxious plants. Those unfortunate enough to see her are glad to escape with their very souls intact!"
					add: -1 1 0 10 12 ; "Somehow, the knight captured Night Mare and rode off on her back, supposedly to the Realm of the Dead. But neither the knight nor his lover ever returned. If there was a means for challenge, it was lost with the knight."
					add: -1 1 0 10 13 ; "I see. Can you tell me anything about the Lord of the Dead?"
					init: self
				)
			)
			(53
				(gMessager say: 1 0 10 14 self) ; "Ah, that is a blacker matter still! To the Druids, he is Samhain, Lord of Coldness and Despair. Samhain was once a man like you or I, but he insulted the gods and was sentenced to rule the Underworld. Immortal he is, and mateless; robbed of sleep, robbed of movement, robbed of companionship."
			)
			(54
				(gMessager say: 1 0 10 15 self) ; "It is said that he hates all mortals even more for the mortality that he lost. That is all I know."
			)
			(55
				(gMessager say: 1 0 10 16 self) ; "Interesting. I shall remember."
			)
			(56
				(gMessager say: 1 0 10 17 self) ; "Now, look how the oak embers of our bonfire still glow hot, despite the rain. If you're bent on your course, you'll need courage that's just as impervious to the chill."
			)
			(57
				(gMessager say: 1 0 10 18 self) ; "<sigh> May your luck last longer than your storm, brave one."
			)
			(58
				(gMessager say: 1 0 10 19 self) ; "May it indeed. Thank you, Arch Druid."
			)
			(59
				(headDruid
					view: 584
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 50 (headDruid y:) self
				)
				(druid setMotion: PolyPath -20 189 self)
				(druid2 setMotion: PolyPath -20 189 self)
			)
			(60 0)
			(61 0)
			(62
				(headDruid dispose:)
				(druid dispose:)
				(druid2 dispose:)
				(gTheIconBar height: 0 activateHeight: 0 enable: 6)
				(Cursor showCursor: 1)
				(= global161 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fire of Actor
	(properties
		x 170
		y 144
		view 589
		signal 16384
		cycleSpeed 17
		detailLevel 3
	)

	(method (doVerb theVerb)
		(bonfire doVerb: theVerb &rest)
	)
)

(instance smoke of Prop
	(properties
		x 169
		y 103
		view 589
		loop 1
		cel 4
		detailLevel 3
	)

	(method (doit)
		(super doit: &rest)
		(= cel (fire cel:))
	)
)

(instance cage of Actor
	(properties
		x 147
		y 124
		noun 9
		onMeCheck 2048
		view 580
	)
)

(instance cageRope of Actor
	(properties
		x 170
		y 54
		view 580
		loop 1
	)
)

(instance druid of Actor
	(properties
		x 82
		y 163
		view 553
	)
)

(instance druid2 of Actor
	(properties
		x 236
		y 163
		view 553
	)
)

(instance headDruid of Actor
	(properties
		x 90
		y 139
		view 5808
	)
)

(instance druid3 of Actor
	(properties
		x 227
		y 129
		view 553
		loop 1
	)
)

(instance druid4 of Prop
	(properties
		x 67
		y 146
		view 553
	)
)

(instance druid5 of Actor
	(properties
		x 240
		y 130
		view 553
	)
)

(instance rope of View
	(properties
		x 196
		y 135
		view 580
		cel 1
		priority 9
		signal 16400
	)
)

(instance bonfire of Feature
	(properties
		noun 4
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 57 58 59 60 96) ; fakeLamp6, fakeLamp4, fakeLamp3, fakeLamp2, fakeLamp1
			(gMessager say: noun 56 0) ; "There's no reason to put embers in a lamp."
		else
			(switch theVerb
				(51 ; skull
					(if (& ((gInventory at: 11) state:) $0008) ; skull
						(gMessager say: noun 51 16 1) ; "The skull already contains hot embers."
					else
						(gGame handsOff:)
						(gCurRoom setScript: getEmbers)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance circleOfStones of Feature
	(properties
		noun 7
		onMeCheck 2
	)
)

(instance trees of Feature
	(properties
		noun 6
		onMeCheck 4
	)
)

(instance cageInset of Inset
	(properties
		view 582
		x 85
		y 32
		priority 13
		noun 8
	)

	(method (init)
		(super init: &rest)
		(inEgo init: setPri: 14)
		(inFire init: setCycle: Fwd cycleSpeed: 10 setPri: 14)
		(inFlame init: setPri: 13 hide:)
		(inBillow init: setPri: 14 hide:)
		(if (and (gEgo has: 19) (== global161 15)) ; huntersLamp
			(gCurRoom setScript: makeRain)
		else
			(gCurRoom setScript: inTheCage)
		)
	)

	(method (drawInset)
		(if (> picture 0)
			(if global169
				(DrawPic picture 15 (if anOverlay 0 else 1))
			else
				(DrawPic
					picture
					(if anOverlay 100 else style)
					(if anOverlay 0 else 1)
				)
			)
		)
		(if view
			(= insetView
				((inView new:)
					view: view
					loop: loop
					cel: cel
					x: x
					y: y
					setPri: priority
					ignoreActors: 1
					init:
					addToPic:
					yourself:
				)
			)
		)
	)

	(method (dispose)
		(inEgo dispose:)
		(inFire dispose:)
		(inBillow dispose:)
		(gAddToPics eachElementDo: #dispose eachElementDo: #delete)
		(super dispose:)
	)
)

(instance inView of View
	(properties)

	(method (handleEvent)
		(return 0)
	)
)

(instance inEgo of Prop
	(properties
		x 162
		y 49
		noun 8
		view 583
	)
)

(instance inFire of Prop
	(properties
		x 149
		y 111
		noun 8
		view 582
		loop 8
		detailLevel 3
	)
)

(instance inFlame of Prop
	(properties
		x 179
		y 88
		noun 8
		view 585
	)
)

(instance inBillow of Prop
	(properties
		x 162
		y 49
		noun 8
		view 5821
		loop 2
		cycleSpeed 15
	)
)

(instance druidConv of Conversation
	(properties)
)

