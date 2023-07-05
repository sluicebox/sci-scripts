;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use n098)
(use Print)
(use Scaler)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm130 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1)
	(limo1 moveSpeed: param1)
	(limo2 moveSpeed: param1)
	(limo3 moveSpeed: param1)
	(wheel1 setSpeed: param1)
	(wheel2 setSpeed: param1)
	(wheel3 setSpeed: param1)
	(wheel4 setSpeed: param1)
)

(instance rm130 of LarryRoom
	(properties
		picture 130
		horizon 0
	)

	(method (init)
		(if (== global100 130)
			(gTextScroller show:)
			(ClearFlag 105)
		)
		(super init: &rest)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(greyDude init: setCycle: Fwd)
		(purpleDude init: setCycle: Fwd)
		(greenDude init: setCycle: Fwd)
		(muscleBabe init: setScript: babeScr)
		(weightLeft init: setScript: weightScr)
		(gGlobalSound1 number: 130 setLoop: -1 play:)
		(gGlobalSound2 number: 811 setLoop: -1 play:)
		(backgroundSnd setLoop: -1 play:)
		(self setScript: startCartoonScr)
		(gEgo
			x: 217
			y: 46
			normalize: 900 8
			setSpeed: 8
			cel: 1
			setScaler: Scaler 100 62 108 42
			init:
			setMotion: MoveTo 181 49 startCartoonScr
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (== (event message:) KEY_RETURN) (& (event type:) evKEYBOARD))
				)
			)
			(proc98_0)
		)
	)

	(method (dispose)
		(gNarrator modeless: 2)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(if (!= (gGlobalSound1 prevSignal:) -1)
			(gGlobalSound1 fade:)
			(gGlobalSound2 fade:)
		)
		(super dispose: &rest)
	)
)

(instance startCartoonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gEgo setMotion: MoveTo 181 49 self)
			)
			(2
				(gEgo setMotion: MoveTo 167 61 self)
			)
			(3
				(gEgo setHeading: 215 self)
			)
			(4
				(= ticks 180)
			)
			(5
				(gMessager sayRange: 0 0 2 1 2 self) ; "Ah! Another busy summer day. You decide to wander down to Muscle Beach to work out..."
			)
			(6
				(= ticks 180)
			)
			(7
				(= next mainCartoonScr)
				(self dispose:)
			)
		)
	)
)

(instance babeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= cycles 2)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(= state -1)
				(= ticks 60)
			)
		)
	)
)

(instance turnEmScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (weightScr state:) 0)
					(weightScr dispose:)
					(= cycles 2)
				else
					(weightScr register: 1 caller: self)
				)
			)
			(1
				(limoSFX play: 0 hold: 1 fade: 127 15 21 0)
				(= ticks 60)
			)
			(2
				(gEgo setHeading: 0)
				(greyDude cue:)
				(= ticks 30)
			)
			(3
				(purpleDude cue:)
				(= ticks 30)
			)
			(4
				(greenDude cue:)
				(muscleBabe view: 1310 loop: 0 cel: 0)
				(= cycles 2)
			)
			(5
				(gMessager say: 0 0 2 3 self) ; "Lost in your work, you nearly miss the Hollywood limousine that pulls in behind you."
			)
			(6
				(UnLoad 128 131)
				(self dispose:)
			)
		)
	)
)

(instance mainCartoonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 132)
				(self setScript: turnEmScr self)
			)
			(1
				(wheel1 init: setMotion: MoveTo 73 33 setCycle: Fwd)
				(wheel2 init: setCycle: Fwd)
				(wheel3 init: setCycle: Fwd)
				(wheel4 init: setCycle: Fwd)
				(limo1 init: setMotion: MoveTo 0 25 self)
				(limo2 init:)
				(limo3 init:)
				(limoFront init: setMotion: MoveTo 105 28)
			)
			(2
				(wheel1 setMotion: MoveTo 182 33)
				(wheel2 setMotion: MoveTo 73 33)
				(limo2 setMotion: MoveTo 0 25 self)
				(limo1 setMotion: MoveTo 109 25)
				(limoFront setMotion: MoveTo 214 28)
			)
			(3
				(wheel1 setMotion: MoveTo 291 33)
				(wheel2 setMotion: MoveTo 182 33)
				(wheel3 setMotion: MoveTo 73 33)
				(limo3 setMotion: MoveTo 0 25 self)
				(limo2 setMotion: MoveTo 109 25)
				(limo1 setMotion: MoveTo 218 25)
				(limoFront setMotion: MoveTo 323 28)
			)
			(4
				(limoFront dispose:)
				(wheel1 setMotion: MoveTo 400 33 wheel1)
				(wheel2 setMotion: MoveTo 400 33 wheel2)
				(wheel3 setMotion: MoveTo 400 33 wheel3)
				(wheel4 setMotion: MoveTo 400 33 wheel4)
				(if (< gHowFast 4)
					(= cycles 2)
				else
					(= ticks 300)
				)
			)
			(5
				(= local0 1)
			)
			(6
				(wheel2 setMotion: 0 setCycle: 0)
				(wheel3 setMotion: 0 setCycle: 0)
				(wheel4 setMotion: 0 setCycle: 0)
				(self setScript: recruitLarryScr self)
			)
			(7
				(wheel1 setMotion: MoveTo 400 33 wheel1)
				(wheel2 setCycle: Fwd setMotion: MoveTo 400 33 wheel2)
				(wheel3 setCycle: Fwd setMotion: MoveTo 400 33 wheel3)
				(wheel4 setCycle: Fwd setMotion: MoveTo 400 33 wheel4)
				(limoSFX hold: 3)
				(gTheDoits add: accelerateLimo)
				(= ticks 200)
			)
			(8
				(cond
					((not (wheel1 cycler:))
						(-- state)
						(= ticks 30)
					)
					((> gHowFast 3)
						(self setScript: toysScr self)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(9
				(= local0 2)
			)
			(10
				(wheel1 setSpeed: 0)
				(wheel2 setSpeed: 0)
				(wheel3 setSpeed: 0)
				(wheel4 setSpeed: 0)
				(limoEnd init: setMotion: MoveTo 328 28 self)
				(limo1 setMotion: MoveTo 327 25)
				(limo2 setMotion: MoveTo 327 25)
				(limo3 setMotion: MoveTo 327 25)
			)
			(11
				(gGlobalSound2 stop:)
				(backgroundSnd stop:)
				(limoSFX fade:)
				(gCast eachElementDo: #hide)
				(gGame hideControls:)
				(gThePlane drawPic: -1 10)
				(= cycles 2)
			)
			(12
				(= ticks 120)
			)
			(13
				(gGlobalSound1 fade: 0 30 10 1)
				(gMessager say: 0 0 2 13 self) ; "After a few glorious moments in the back of the limo (in which you act out your favorite scene from "No Way Out" while Shalo acts out her favorite scene from "Ice Station Zebra") you arrive at the studio, and are escorted directly to the set, where an episode of "Stallions" is being taped."
			)
			(14
				(= ticks 120)
			)
			(15
				(gCurRoom newRoom: 140)
				(self dispose:)
			)
		)
	)
)

(instance recruitLarryScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(sfx number: 135 loop: 1 play:)
				(limoRoof
					init:
					setPri: (+ (wheel1 priority:) 1)
					setCycle: End self
				)
			)
			(2
				(limoBabe
					init:
					setPri: (+ (limoRoof priority:) 1)
					posn: (- (wheel1 x:) 38) (- (wheel1 y:) 14)
					setCycle: End self
				)
			)
			(3
				(= ticks 45)
			)
			(4
				(gMessager say: 0 0 2 4 self) ; "As the limo stops, a beautiful blonde emerges from the sunroof to announce..."
			)
			(5
				(gMessager say: 0 0 2 5 self) ; "My name is Shalo. And I'm looking for one very good man..."
			)
			(6
				(gEgo setScaler: Scaler 77 63 61 43)
				(greenDude view: 132 loop: 2 setMotion: MoveTo 189 103 self)
			)
			(7
				(greenDude setMotion: MoveTo 170 64 self)
				(purpleDude view: 132 loop: 1 setMotion: MoveTo 179 66 self)
				(greyDude view: 132 loop: 3 setMotion: MoveTo 158 63 self)
			)
			(8
				(gNarrator x: 86 y: 40 modeless: 1)
				(Print addTitle: {Buffed One})
				(gMessager say: 0 0 2 6 self) ; "Outta the way, bub!"
			)
			(9)
			(10
				(gNarrator x: 100 y: 55)
				(Print addTitle: {Beach God})
				(gMessager say: 0 0 2 7 self) ; "Lemme at her!"
			)
			(11
				(gNarrator x: 160 y: 55)
				(Print addTitle: {Body Boy})
				(gMessager say: 0 0 2 8 self) ; "Move it!"
			)
			(12
				(Print title: 0)
				(gNarrator modeless: 2)
				(greyDude
					setMotion: MoveTo (greyDude x:) (- (greyDude y:) 18) self
				)
				(greenDude
					setMotion: MoveTo (greenDude x:) (- (greenDude y:) 18) self
				)
				(purpleDude
					setMotion:
						MoveTo
						(purpleDude x:)
						(- (purpleDude y:) 18)
						self
				)
				(gEgo setSpeed: 0 setMotion: MoveTo 160 43 self)
			)
			(13 0)
			(14 0)
			(15 0)
			(16
				(Load rsVIEW 133)
				(gMessager say: 0 0 2 9 self) ; "...to appear on the new TV show, "Stallions!""
			)
			(17
				(= local1 1)
				(purpleDude
					view: 133
					loop: 1
					setMotion: MoveTo 231 111 purpleDude
				)
				(greenDude
					view: 133
					loop: 2
					setMotion: MoveTo 206 132 greenDude
				)
				(greyDude view: 133 loop: 3 setMotion: MoveTo 151 100 greyDude)
			)
			(18 0)
			(19 0)
			(20
				(= cycles 2)
			)
			(21
				(gMessager sayRange: 0 0 2 10 12 self) ; "(SIGH) Well, I guess you'll have to do. What's your name?"
			)
			(22
				(limoBabe setCycle: Beg self)
			)
			(23
				(limoRoof setCycle: Beg self)
			)
			(24
				(limoRoof dispose:)
				(= ticks 30)
			)
			(25
				(Load rsSOUND 136 137)
				(sfx number: 136 play:)
				(limoDoor
					posn: 192 32
					init:
					setPri: (+ (wheel1 priority:) 1)
					setCycle: End self
				)
			)
			(26
				(gEgo
					view: 1304
					loop: 2
					cel: 0
					setSpeed: 10
					setScale: 0
					posn: 160 41
					setCycle: End self
				)
			)
			(27
				(gEgo hide:)
				(limoDoor setCycle: Beg self)
			)
			(28
				(sfx number: 137 play:)
				(if
					(or
						(greyDude mover:)
						(purpleDude mover:)
						(greenDude mover:)
					)
					(-- state)
				)
				(= ticks 30)
			)
			(29
				(UnLoad 132 136 137)
				(limoDoor dispose:)
				(= ticks 30)
			)
			(30
				(if global205
					(proc79_7)
				)
				(self dispose:)
			)
		)
	)
)

(instance greyDude of Actor
	(properties
		x 147
		y 101
		view 131
		loop 1
		yStep 3
		signal 18465
		cycleSpeed 55
		illegalBits 0
	)

	(method (cue)
		(self
			view: 134
			setLoop: (if (== (mainCartoonScr script:) turnEmScr) 0 else 1) 1
			posn: 151 100
			cel: 2
			setSpeed: 0
			setCycle: Walk
			setScaler: Scaler 100 76 100 63
		)
		(if local1
			(recruitLarryScr cue:)
		)
	)
)

(instance purpleDude of Actor
	(properties
		x 231
		y 105
		view 131
		loop 3
		yStep 4
		signal 18465
		cycleSpeed 14
		illegalBits 0
	)

	(method (cue)
		(self
			view: 134
			setLoop: (if (== (mainCartoonScr script:) turnEmScr) 0 else 1) 1
			posn: 231 111
			cel: 0
			setSpeed: 0
			setCycle: Walk
			setScaler: Scaler 100 76 111 66
		)
		(if local1
			(recruitLarryScr cue:)
		)
	)
)

(instance greenDude of Actor
	(properties
		x 195
		y 123
		priority 199
		fixPriority 1
		view 131
		loop 2
		cel 9
		yStep 4
		signal 18465
		cycleSpeed 15
		illegalBits 0
	)

	(method (cue)
		(self
			view: 134
			setLoop: (if (== (mainCartoonScr script:) turnEmScr) 0 else 1) 1
			posn: 206 132
			cel: 1
			setSpeed: 0
			setCycle: Walk
			setScaler: Scaler 100 68 112 64
			setPri: -1
		)
		(if local1
			(recruitLarryScr cue:)
		)
	)
)

(instance muscleBabe of Actor
	(properties
		x 87
		y 120
		view 131
		loop 5
		cel 8
		signal 18465
		cycleSpeed 30
		illegalBits 0
	)
)

(instance decelerateLimo of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(cond
			((>= (= temp0 (wheel1 x:)) 194)
				(gTheDoits delete: self)
			)
			(
				(and
					(>= temp0 175)
					(!= (= temp1 (- 20 (- 194 temp0))) (wheel1 moveSpeed:))
				)
				(if (== (wheel1 moveSpeed:) 0)
					(limoSFX hold: 2)
				)
				(localproc_0 temp1)
			)
		)
	)
)

(instance accelerateLimo of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(cond
			((>= (= temp0 (wheel1 x:)) 215)
				(gTheDoits delete: self)
				(if (!= (limo1 moveSpeed:) 0)
					(localproc_0 0)
				)
			)
			(
				(and
					(<= temp0 214)
					(!= (= temp1 (- 214 temp0)) (wheel1 moveSpeed:))
				)
				(localproc_0 temp1)
			)
		)
	)
)

(instance wheel1 of Actor
	(properties
		x -36
		y 33
		priority 33
		fixPriority 1
		view 130
		loop 1
		signal 18465
		cycleSpeed 0
		moveSpeed 0
	)

	(method (cue)
		(cond
			((== local0 2)
				(= local0 3)
				(mainCartoonScr cue:)
			)
			((!= local0 1)
				(if (not cycler)
					(self view: 130 loop: 1)
					(self setCycle: Fwd)
				)
				(self posn: -36 33 setMotion: MoveTo 400 33 self)
			)
			(else
				(= local0 0)
				(self
					view: 1303
					loop: 0
					cel: 1
					posn: -36 33
					setCycle: 0
					setMotion: MoveTo 194 33 mainCartoonScr
				)
				(gTheDoits add: decelerateLimo)
			)
		)
	)
)

(instance wheel2 of Actor
	(properties
		x -36
		y 33
		view 130
		loop 1
		signal 18465
		cycleSpeed 0
		moveSpeed 0
	)

	(method (cue)
		(if (!= local0 3)
			(self posn: -36 33 setMotion: MoveTo 400 33 self)
		)
	)
)

(instance wheel3 of Actor
	(properties
		x -36
		y 33
		view 130
		loop 1
		signal 18465
		cycleSpeed 0
		moveSpeed 0
	)

	(method (cue)
		(if (!= local0 3)
			(self posn: -36 33 setMotion: MoveTo 400 33 self)
		)
	)
)

(instance wheel4 of Actor
	(properties
		x -36
		y 33
		view 130
		loop 1
		signal 18465
		cycleSpeed 0
		moveSpeed 0
	)

	(method (cue)
		(if (!= local0 3)
			(self posn: -36 33 setMotion: MoveTo 400 33 self)
		)
	)
)

(instance limoFront of Actor
	(properties
		y 28
		view 1303
		cel 2
		signal 18465
		moveSpeed 0
	)
)

(instance limoEnd of Actor
	(properties
		x -5
		y 28
		view 1303
		signal 18465
		moveSpeed 0
	)
)

(instance limoBabe of Prop
	(properties
		view 1301
		signal 18465
	)
)

(instance limoRoof of Prop
	(properties
		x 154
		y 19
		priority 19
		fixPriority 1
		view 1301
		loop 1
		signal 18465
	)
)

(instance limoDoor of Actor
	(properties
		view 1304
	)
)

(instance limoToy of Actor
	(properties
		y 24
		view 1302
		signal 18465
		moveSpeed 0
	)
)

(instance limo1 of Actor
	(properties
		x -104
		y 25
		priority 25
		fixPriority 1
		view 130
		signal 18465
		moveSpeed 0
	)
)

(instance limo2 of Actor
	(properties
		x -109
		y 25
		view 130
		signal 18465
		moveSpeed 0
	)
)

(instance limo3 of Actor
	(properties
		x -109
		y 25
		view 130
		signal 18465
		moveSpeed 0
	)
)

(instance limoSFX of Sound
	(properties
		flags 5
		number 134
		loop -1
	)
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance backgroundSnd of Sound
	(properties
		flags 5
		number 812
		loop -1
	)
)

(instance toysScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(limoToy setPri: (+ (limo1 priority:) 1) init: hide:)
				(= cycles 2)
			)
			(1
				(limoToy
					show:
					posn:
						(-
							(*
								(CelWide
									(limoToy view:)
									(limoToy loop:)
									(limoToy cel:)
								)
								-1
							)
							5
						)
						(limoToy y:)
					setMotion: MoveTo 322 (limoToy y:) self
				)
			)
			(2
				(switch (++ register)
					(1
						(limoToy cel: 1)
						(-= state 2)
					)
					(2
						(limoToy cel: 2)
						(-= state 2)
					)
				)
				(= ticks 120)
			)
			(3
				(limoToy dispose:)
				(self dispose:)
			)
		)
	)
)

(instance weightBar of View
	(properties
		x 152
		y 139
		priority 200
		fixPriority 1
		view 1305
		loop 2
	)
)

(instance weightRight of Prop
	(properties
		x 214
		y 139
		priority 200
		fixPriority 1
		view 1305
		cycleSpeed 10
	)
)

(instance weightLeft of Prop
	(properties
		x 89
		y 139
		priority 200
		fixPriority 1
		view 1305
		loop 1
		cycleSpeed 10
	)
)

(instance weightScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(weightLeft hide:)
				(weightRight init: hide:)
				(= ticks 30)
			)
			(1
				(weightLeft show: setCycle: CT 5 1 self)
				(weightRight show: setCycle: CT 5 1 self)
			)
			(2 0)
			(3
				(= ticks 6)
			)
			(4
				(weightLeft cel: 6)
				(weightRight cel: 6)
				(weightBar init:)
				(= ticks 40)
			)
			(5
				(weightLeft cel: 5)
				(weightRight cel: 5)
				(weightBar dispose:)
				(= ticks 1)
			)
			(6
				(weightRight setCycle: Beg self)
				(weightLeft setCycle: Beg self)
			)
			(7 0)
			(8
				(= cycles 2)
			)
			(9
				(weightRight hide:)
				(weightLeft hide:)
				(if register
					(weightRight dispose:)
					(client dispose:)
				else
					(= ticks (Random 180 280))
					(= state 0)
				)
			)
		)
	)
)

