;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2155)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use n777)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2155 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1)
	(if (or (== argc 0) (== param1 1))
		(for ((= temp0 100)) (> temp0 0) ((-= temp0 param2))
			(Palette 2 0 71 temp0) ; PalIntensity
			(Palette 2 104 235 temp0) ; PalIntensity
			(gCast doit:)
			(FrameOut)
		)
	else
		(for ((= temp0 0)) (< temp0 100) ((+= temp0 param2))
			(Palette 2 0 71 temp0) ; PalIntensity
			(Palette 2 104 235 temp0) ; PalIntensity
			(gCast doit:)
			(FrameOut)
		)
	)
	(if (and (== argc 3) param3)
		(param3 cue:)
	)
)

(instance rm2155 of KQRoom
	(properties
		picture 2155
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 55 73 63 70 94 58 103 47 103 42 113 37 119 45 135 40 137 38 119 41 115 33 96 44 75 50 55 62 53 71 52 75
					yourself:
				)
		)
		(= gValOrRoz -3) ; Roz
		(Load rsVIEW 2156 2157 2158 2159 2160 2161 2162)
		(Load 140 812 835 2105 2151 2261 4364 4081 4073) ; WAVE
		(Load 140 871 871 2156) ; WAVE
		(backWall init:)
		(ledgeEdge init:)
		(sound2 flags: 5 owner: self init:)
		(if (== gPrevRoomNum 2150)
			(shakeTimer setReal: shakeTimer (Random 4 8))
		)
		(cond
			((== gPrevRoomNum 2204)
				(self setScript: sRosellaPoofsIntoCone)
			)
			((== gPrevRoomNum 6010)
				(self setScript: sScaredOfTheLava)
			)
			((== gPrevRoomNum 2150)
				(self setScript: sDoSomething)
			)
			(else
				(self setScript: sScaredOfTheLava)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (IsFlag 255) (not script))
			(ClearFlag 255)
			(gCurRoom setScript: sRisingLava)
		)
	)

	(method (dispose)
		(shakeTimer client: 0 delete: dispose:)
		(if local5
			(Palette 2 0 71 100) ; PalIntensity
			(Palette 2 104 235 100) ; PalIntensity
			(gKqSound1 fade:)
		)
		(super dispose:)
	)
)

(instance sRosellaPoofsIntoCone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqMusic1 stop: number: 2150 setLoop: -1 play:)
				(= cycles 1)
			)
			(1
				(rose
					view: 2156
					posn: 90 61
					init:
					setCel: 0 1
					setLoop: 0
					setCycle: End self
				)
				(gKqSound1 stop: number: 2105 setLoop: 1 play:)
			)
			(2
				(rose
					view: 2159
					posn: 84 63
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
				(gKqSound1 stop: number: 4364 setLoop: 1 play:)
			)
			(3
				(rose setLoop: 0 setCel: 12 setCycle: Beg self)
			)
			(4
				(rose view: 2156 posn: 92 61 setLoop: 1 setCycle: End self)
			)
			(5
				(= ticks 180)
			)
			(6
				(rose cycleSpeed: 10 setCel: 0 1 setLoop: 2 setCycle: End self)
			)
			(7
				(rose cycleSpeed: 10 posn: 79 63 setLoop: 3 setCycle: End self)
			)
			(8
				(gKqSound1 stop: number: 2151 setLoop: 1 play: self)
			)
			(9
				(gKqSound1 fade:)
				(gCurRoom newRoom: 6010)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sScaredOfTheLava of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqMusic1 stop: number: 2150 setLoop: -1 play:)
				(rose view: 2157 init:)
				(= cycles 1)
			)
			(1
				(rose view: 2157 setLoop: 0 setCel: 1 setCycle: End)
				(gKqSound1 number: 835 setLoop: 1 play:)
				(lava init: setCel: 0 setLoop: 0 setCycle: End self)
				(gKqSound1 number: 2261 setLoop: -1 play:)
			)
			(2
				(lava cycleSpeed: 15 setCel: 0 setLoop: 1 setCycle: Fwd)
				(= ticks 210)
			)
			(3
				(if (> (gGame speedRating:) 165)
					(localproc_0 1 4 self)
				else
					(localproc_0 1 7 self)
				)
				(= local5 1)
			)
			(4
				(rose hide:)
				(cave hide:)
				(lava hide:)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(gCurRoom newRoom: 2150)
				(self dispose:)
			)
		)
	)
)

(instance sDoSomething of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 0)
				(= local0 1)
				(= local1 1)
				(gKqMusic1 stop: number: 2150 setVol: 100 setLoop: -1 play:)
				(gKqSound1 stop: number: 2261 setLoop: -1 play:)
				(lava init: cycleSpeed: 15 setCel: 0 setLoop: 1 setCycle: Fwd)
				(rose
					init:
					view: 2156
					loop: 3
					cel: 0
					posn: 65 65
					setCycle: End self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRisingLava of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(shakeTimer setReal: shakeTimer 1000)
				(smoke init: setLoop: 3 1 setCel: 0 setCycle: End self)
				(bubble setPri: 90 init: cel: 0 setCycle: End)
			)
			(1
				(smoke dispose:)
				(bubble dispose:)
				(rose
					view: 2159
					x: 40
					y: 135
					setPri: 90
					setScale:
					scaleX: 128
					scaleY: 128
					setLoop: 1 1
					setCel: 0
					setCycle: CT 17 1 self
				)
				(sound2 stop:)
				(gKqSound1 stop: number: 4073 setLoop: 1 play:)
			)
			(2
				(gKqSound1 number: 812 setLoop: 1 play:)
				(rose setCycle: End self)
			)
			(3
				(rose dispose:)
				(= cycles 1)
			)
			(4
				(= cycles 1)
			)
			(5
				(shakeTimer setReal: shakeTimer (Random 4 8))
				(gCurRoom setScript: sDoSomething)
				(EgoDead 38 gCurRoom self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosella_Falls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(shakeTimer setReal: shakeTimer 1000)
				(gKqSound1 number: 4073 setLoop: 1 play:)
				(rose
					view: 2159
					x: (- (rose x:) 25)
					y: (+ (rose y:) 70)
					setCel: 0
					setScale:
					scaleX: 128
					scaleY: 128
					setLoop: 1 1
					setCycle: CT 17 1 self
				)
			)
			(1
				(sound2 stop:)
				(gKqSound1 stop: number: 812 setLoop: 1 play:)
				(rose setCycle: End self)
			)
			(2
				(rose dispose:)
				(= cycles 1)
			)
			(3
				(= cycles 1)
			)
			(4
				(shakeTimer setReal: shakeTimer (Random 4 8))
				(if (== local3 1)
					(hole dispose:)
				)
				(EgoDead 37 gCurRoom self)
			)
			(5
				(gCurRoom setScript: sDoSomething)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRoseMove1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rose
					view: 2160
					x: (+ (rose x:) 11)
					y: (- (rose y:) 5)
					setCel: 0
					setLoop: 2
					setCycle: End self
				)
			)
			(1
				(gCurRoom setScript: sRosellaGroping)
				(self dispose:)
			)
		)
	)
)

(instance sRosellaGroping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 1)
				(rose
					view: 2160
					posn: 80 60
					setScale:
					scaleX: 128
					scaleY: 128
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: CT 16 1 self
				)
			)
			(1
				(hole posn: 76 25 init:)
				(gKqSound1 number: 2155 setLoop: 1 setVol: 127 play: self)
			)
			(2
				(rose setCel: 16 setCycle: End self)
			)
			(3
				(gKqSound1 stop: number: 2261 setLoop: -1 play:)
				(rose setCel: 19 setCycle: CT 12 -1 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRoseMove2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rose
					view: 2160
					x: (+ (rose x:) 1)
					y: (- (rose y:) 3)
					setLoop: 0
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(rose
					x: (+ (rose x:) 1)
					y: (- (rose y:) 3)
					setCel: 4
					setCycle: CT 8 1 self
				)
			)
			(2
				(rose
					x: (+ (rose x:) 1)
					y: (- (rose y:) 3)
					setCel: 8
					setCycle: CT 4 -1 self
				)
			)
			(3
				(rose
					x: (+ (rose x:) 1)
					y: (- (rose y:) 3)
					setCel: 4
					setCycle: CT 0 -1 self
				)
			)
			(4
				(gCurRoom setScript: sHandsDig)
				(self dispose:)
			)
		)
	)
)

(instance sHandsDig of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(emergingCave init: cycleSpeed: 10 cycleSpeed: 14 setCycle: End)
				(dirt init: cycleSpeed: 14 setCycle: Fwd)
				(shovelDirt init: posn: 72 54 cycleSpeed: 14 setCycle: End)
				(rose
					view: 2161
					setPri: 60
					setScale:
					scaleX: 128
					scaleY: 128
					posn: 78 48
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(rose setCel: 0 setCycle: End self)
			)
			(2
				(gCurRoom setScript: sEnteringCave)
				(self dispose:)
			)
		)
	)
)

(instance sShovelDig of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== local4 1)
					(rose
						view: 2160
						x: (+ (rose x:) 1)
						y: (- (rose y:) 3)
						setLoop: 0
						setCel: 0
						setCycle: CT 4 1 self
					)
				else
					(rose
						x: (+ (rose x:) 1)
						y: (- (rose y:) 3)
						setCel: 7
						setCycle: Beg self
					)
				)
			)
			(1
				(if (== local4 1)
					(rose
						x: (+ (rose x:) 1)
						y: (- (rose y:) 3)
						setCel: 4
						setCycle: CT 8 1 self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if (== local4 1)
					(rose view: 2160 cel: 7 loop: 2 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(3
				(rose
					view: 2162
					cycleSpeed: 9
					setScale:
					scaleX: 128
					scaleY: 128
					posn: 98 59
					setLoop: 0
					setCel: 0
					setCycle: CT 20 1 self
				)
			)
			(4
				(gKqSound1 number: 4081 setLoop: 1 play: self)
			)
			(5
				(shovelDirt init: cel: 0 setCycle: End)
				(rose cel: 21 setCycle: CT 25 1 self)
			)
			(6
				(gKqSound1 number: 4081 setLoop: 1 play: self)
				(rose cel: 21 setCycle: CT 25 1 self)
			)
			(7
				(gKqSound1 number: 4081 setLoop: 1 play: self)
				(rose cel: 21 setCycle: End self)
			)
			(8
				(gKqSound1 stop:)
				(gCurRoom setScript: sEnteringCave)
				(self dispose:)
			)
		)
	)
)

(instance sEnteringCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqSound1 number: 2261 setLoop: -1 play:)
				(cave posn: 80 43 init:)
				(rock posn: 81 5 init:)
				(= cycles 1)
			)
			(1
				(rose
					view: 2162
					setPri: 60
					setScale:
					scaleX: 128
					scaleY: 128
					posn: 80 45
					cycleSpeed: 14
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(rose dispose:)
				(= cycles 1)
			)
			(3
				(= cycles 1)
			)
			(4
				(if (> (gGame speedRating:) 165)
					(localproc_0 1 4 self)
				else
					(localproc_0 1 7 self)
				)
				(= local5 1)
			)
			(5
				(lava hide:)
				(cave hide:)
				(rock hide:)
				(gKqSound1 fade: 0 60 10 1)
				(= cycles 2)
			)
			(6
				(sound2 fade:)
				(gCurRoom newRoom: 4050)
				(self dispose:)
			)
		)
	)
)

(instance sRegainsBalance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rose
					view: 2159
					setCel: 0
					setScale:
					scaleX: 128
					scaleY: 128
					setLoop: 0 1
					setCycle: End self
				)
			)
			(1
				(rose cel: 12 setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance backWall of Feature
	(properties)

	(method (init)
		(super init:)
		(= local0 1)
		(self
			setHotspot: 8 10 75 ; Do, Exit, Shovel
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 14 35 48 69 67 53 100 39 117 34 100 0 2 0
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if local0
					(gCurRoom setScript: sRoseMove1)
					(= local0 0)
					(= local4 1)
				else
					(gCurRoom setScript: sRoseMove2)
				)
			)
			(75 ; Shovel
				(gCurRoom setScript: sShovelDig)
			)
		)
	)
)

(instance ledgeEdge of Feature
	(properties)

	(method (init)
		(super init:)
		(= local1 1)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 50 74 54 72 59 73 100 55 106 46 104 47 111 38 103 45 99 53
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if local1
					(= local1 0)
					(gCurRoom setScript: sRegainsBalance)
				else
					(gCurRoom setScript: sRosella_Falls)
				)
			)
		)
	)
)

(instance rose of Prop
	(properties
		x 65
		y 65
		view 2156
		loop 3
	)
)

(instance lava of Prop
	(properties
		x 160
		y 139
		view 2158
	)

	(method (init)
		(super init: &rest)
		(self setPri: 40)
	)
)

(instance smoke of Prop
	(properties
		x 120
		y 80
		view 2158
		loop 3
	)
)

(instance dirt of Prop
	(properties
		x 76
		y 52
		view 2161
		loop 1
	)
)

(instance emergingCave of Prop
	(properties
		x 76
		y 52
		view 2161
		loop 2
	)
)

(instance bubble of Prop
	(properties
		x 160
		y 110
		view 2158
		loop 2
	)
)

(instance shovelDirt of Prop
	(properties
		x 32
		y 78
		view 2161
		loop 4
	)
)

(instance cave of View
	(properties
		view 2162
		loop 2
	)
)

(instance rock of View
	(properties
		view 2162
		loop 2
		cel 1
	)
)

(instance hole of View
	(properties
		view 2160
		loop 1
	)
)

(instance sound2 of Sound
	(properties
		number 871
	)
)

(instance shakeTimer of Timer
	(properties)

	(method (cue)
		(sound2 setLoop: 1 play:)
		(cond
			((> (gGame speedRating:) 165)
				(proc777_0 gThePlane 1 5)
			)
			((> (gGame speedRating:) 90)
				(proc777_0 gThePlane 1 3)
			)
			((> (gGame speedRating:) 40)
				(proc777_0 gThePlane 1 (Random 1 2))
			)
		)
		(self setReal: self (Random 4 8))
	)
)

