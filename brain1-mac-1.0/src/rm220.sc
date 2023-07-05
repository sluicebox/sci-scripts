;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm220 0
)

(local
	[local0 8] = [54 52 44 44 52 12 5 12]
	[local8 48] = [7 1 11 11 1 4 7 4 0 0 0 0 0 0 0 0 0 0 0 0 3 4 0 2 1 2 4 3 0 1 3 4 5 0 0 0 0 0 1 2 4 8 16 {(A) Multiply.....} {(B) Apply CPU.....} {(C) It has square roots.....} {(D) To avoid short circuits.....} {(E) A cowculator.....}]
	[local56 20] = [{What's special about} {the way a robot plant} {grows?} {} 7719 {does a dairy farmer} {use?} {} {Why do robots always} {take the longest path} {between two points?} {} {What do robot rabbits} {do best?} {} {} {What should you do } {when a robot is } {having a heart attack?} {}]
	local76
	local77
	local78
	local79
	[local80 4] = [130 115 130 100]
	[local84 5] = [1 2 4 8 16]
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(= temp0 0)
	(= temp1 param1)
	(Graph grFILL_BOX 57 125 94 265 1 [local0 3] -1 -1)
	(Graph grUPDATE_BOX 57 125 94 265 1)
	(while (and (< temp0 4) (StrLen [local56 temp1]))
		(Display
			[local56 temp1]
			dsCOORD
			125
			(+ 57 (* temp0 10))
			dsCOLOR
			[local0 4]
			dsALIGN
			alLEFT
			dsFONT
			200
			&rest
		)
		(++ temp0)
		(++ temp1)
	)
)

(instance rm220 of Rm
	(properties
		lookStr {This is the second floor hallway, the computer hall.}
		picture 220
		style 7
		south 200
	)

	(method (init &tmp temp0)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 8) ((++ temp0))
				(= [local0 temp0] [local8 temp0])
			)
		)
		(LoadMany rsSOUND 52 58 59 221 912 931 958 959)
		(super init:)
		(gCMusic number: 220 setLoop: -1 flags: 1 play:)
		(lightBulb init:)
		(lightedFloor init: hide:)
		(if (not (IsFlag 55))
			(leftDoor init:)
		else
			(lightedFloor show:)
			(leftDoorway init:)
		)
		(if (not (IsFlag 56))
			(rightDoor init:)
		else
			(rightDoorway init:)
		)
		(backDoor init:)
		(screen init:)
		(trashCan init:)
		(spears init:)
		(maceHead init:)
	)

	(method (dispose)
		(gCMusic fade: 0 15 12 1)
		(gCMusic2 stop:)
		(super dispose: &rest)
	)
)

(instance leftDoorSound of Sound
	(properties
		flags 1
		number 912
	)
)

(instance rightDoorSound of Sound
	(properties
		flags 1
		number 931
	)
)

(instance leftDoor of Prop
	(properties
		x 67
		y 180
		description {left-hand door}
		sightAngle 180
		lookStr {Through the window you can see a maze. There is a robot moving through the maze.}
		view 220
		cel 1
	)

	(method (doVerb theVerb invItem)
		(cond
			((== 1 (robotJokes sel_619:))
				(return)
			)
			((not (or (== theVerb 3) (and (== theVerb 4) (== invItem 8))))
				(super doVerb: theVerb &rest)
			)
			((gEgo has: 8)
				(SetFlag 55)
				(leftDoorSound play:)
				(self setScript: openLeftDoor)
			)
			(else
				(proc5_9 220 0)
			)
		)
	)
)

(instance rightDoor of Prop
	(properties
		x 271
		y 34
		description {right-hand door}
		sightAngle 180
		lookStr {This high-tech door is labelled "Computer Room".}
		view 220
		loop 4
		cel 1
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(cond
			((== 1 (robotJokes sel_619:))
				(return)
			)
			((== theVerb 3)
				(SetFlag 56)
				(rightDoorSound play:)
				(self setScript: openRightDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 187
		y 50
		view 220
		loop 6
		priority 10
		signal 16
	)
)

(instance backDoor of Prop
	(properties
		x 177
		y 87
		description {back door}
		lookStr {The console built into this door says "Robot Riddles".}
		view 220
		loop 3
	)

	(method (doVerb theVerb invItem)
		(cond
			((== 1 (robotJokes sel_619:))
				(return)
			)
			((== theVerb 3)
				(cond
					((not (gEgo has: 8))
						(proc5_9 220 1)
					)
					((IsFlag 41)
						(self setScript: openBackDoor)
					)
					(else
						(screen setScript: showJokes)
					)
				)
			)
			((and (== theVerb 4) (gEgo has: 8))
				(screen setScript: showJokes)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance showJokes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (screen cel:))
					(screen setCycle: End self)
				else
					(= ticks 1)
				)
			)
			(1
				(if (not (IsFlag 41))
					(robotJokes init:)
				else
					(backDoor setScript: openBackDoor)
				)
				(self dispose:)
			)
		)
	)
)

(instance maceHead of Prop
	(properties
		x 141
		y 79
		description {mace head}
		lookStr {It's a spinning mace and flail. Better stay clear.}
		view 220
		loop 2
	)

	(method (doVerb theVerb)
		(cond
			((== 1 (robotJokes sel_619:))
				(return)
			)
			((== theVerb 3)
				(if (self cycler:)
					(gCMusic2 stop:)
					(self setCycle: 0)
				else
					(gCMusic2 number: 221 flags: 1 setLoop: -1 play:)
					(self setCycle: Fwd)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bulbSound of Sound
	(properties
		flags 1
		number 58
	)
)

(instance lightBulb of Prop
	(properties
		x 93
		y 55
		description {light bulb}
		onMeCheck 16384
		lookStr {It's one of those capacitive, touch-controlled light bulbs.}
		view 220
		loop 1
	)

	(method (doVerb theVerb)
		(cond
			((== 1 (robotJokes sel_619:))
				(return)
			)
			((== theVerb 3)
				(bulbSound play:)
				(if (self cel:)
					(gCMusic2 stop:)
					(maceHead setCycle: 0)
					(self setCel: 0)
				else
					(gCMusic2 number: 221 flags: 1 setLoop: -1 play:)
					(maceHead setCycle: Fwd)
					(self setCel: 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lightedFloor of Prop
	(properties
		x 81
		y 182
		view 220
		loop 5
		priority 8
		signal 16400
	)
)

(instance leftDoorway of Feature
	(properties
		description {doorway}
		onMeCheck 2
	)

	(method (onMe param1)
		(return (& onMeCheck (OnControl CONTROL (param1 x:) (param1 y:))))
	)

	(method (doVerb theVerb)
		(cond
			((== 1 (robotJokes sel_619:))
				(return)
			)
			((and (== theVerb 3) (not (>= global176 (+ 3 global114))))
				(gCurRoom newRoom: 260)
			)
			((== theVerb 3)
				(proc5_9 220 2)
			)
			((and (== theVerb 2) (IsFlag 55))
				(proc5_9 220 3)
			)
			(2
				(proc5_9 220 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightDoorway of Feature
	(properties
		description {doorway}
		onMeCheck 4
	)

	(method (onMe param1)
		(return (& onMeCheck (OnControl CONTROL (param1 x:) (param1 y:))))
	)

	(method (doVerb theVerb)
		(cond
			((== 1 (robotJokes sel_619:))
				(return)
			)
			((and (== theVerb 3) (not (IsFlag 17)))
				(gCurRoom newRoom: 240)
			)
			((== theVerb 3)
				(proc5_9 220 5)
			)
			((and (== theVerb 2) (IsFlag 56))
				(proc5_9 220 6)
			)
			((== theVerb 2)
				(proc5_9 220 7)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance openLeftDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leftDoor setCycle: Beg self)
				(lightedFloor show:)
			)
			(1
				(proc5_9 220 8)
				(gCurRoom newRoom: 260)
				(self dispose:)
			)
		)
	)
)

(instance openBackDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(screen dispose:)
				(leftDoorSound play:)
				(backDoor setCycle: End self)
			)
			(1
				(proc5_9 220 9)
				(gCurRoom newRoom: 280)
				(self dispose:)
			)
		)
	)
)

(instance openRightDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rightDoor setCycle: Beg self)
			)
			(1
				(proc5_9 220 10)
				(gCurRoom newRoom: 240)
				(self dispose:)
			)
		)
	)
)

(instance rewardSound of Sound ; UNUSED
	(properties
		flags 1
		number 52
	)
)

(class PPath of MoveTo
	(properties
		sel_620 0
		intermediate 0
		value 1
		sel_621 0
		sel_622 2
	)

	(method (init param1 param2 param3 param4 param5 param6)
		(= client param1)
		(= sel_620 param2)
		(= value (+ (* 2 param3) 1))
		(= sel_621 (+ (* 2 param4) 1))
		(= caller param5)
		(= intermediate param6)
		(if (> value sel_621)
			(= sel_622 -2)
		)
		(+= sel_621 sel_622)
		(= x (client x:))
		(= y (client y:))
		(if (self atEnd:)
			(self moveDone:)
		else
			(= x (WordAt sel_620 (- value 1)))
			(= y (WordAt sel_620 value))
			(+= value sel_622)
			(super init: client x y)
		)
	)

	(method (moveDone)
		(if (self atEnd:)
			(super moveDone:)
		else
			(intermediate cue: (/ value 2))
			(= x (WordAt sel_620 (- value 1)))
			(= y (WordAt sel_620 value))
			(+= value sel_622)
			(super init: client x y)
		)
	)

	(method (atEnd)
		(return
			(if sel_621
				(== sel_621 value)
			else
				(or
					(== (WordAt sel_620 (- value 1)) -32768)
					(== (WordAt sel_620 value) -32768)
				)
			)
		)
	)
)

(instance cButton of View
	(properties
		x 115
		y 20
		view 947
		loop 10
	)

	(method (doVerb &tmp temp0)
		(= temp0 0)
		(switch local78
			(0
				(if (not (& global166 [local84 2]))
					(= temp0 1)
				)
			)
			(4
				(if (not (& global166 [local84 4]))
					(= temp0 1)
				)
			)
			(8
				(if (not (& global166 [local84 3]))
					(= temp0 1)
				)
			)
			(12
				(if (not (& global166 [local84 0]))
					(= temp0 1)
				)
			)
			(16
				(if (not (& global166 [local84 1]))
					(= temp0 1)
				)
			)
		)
		(cond
			((not global115)
				(proc5_11 220 11)
			)
			((== temp0 1)
				(proc5_11 220 12)
			)
			(else
				(if (not (-- global115))
					(gEgo put: 0)
					(proc5_11 220 13)
				else
					(proc5_21
						220
						14
						global115
						(if (== global115 1) { } else {s })
					)
				)
				(switch local78
					(0
						(= local77 3)
					)
					(4
						(= local77 5)
					)
					(8
						(= local77 4)
					)
					(12
						(= local77 1)
					)
					(16
						(= local77 2)
					)
				)
				(robotJokes sel_623:)
			)
		)
	)
)

(instance eButton of View
	(properties
		x 180
		y 20
		view 947
		loop 9
	)

	(method (doVerb)
		(robotJokes dispose:)
	)
)

(instance qButton of View
	(properties
		x 255
		y 20
		view 947
		loop 7
	)

	(method (doVerb)
		(proc5_9 220 15)
		(proc5_9 220 16)
	)
)

(instance aString of Actor
	(properties
		x 130
		y 137
		view 888
	)

	(method (cue &tmp temp0)
		(if (== local79 4)
			(= local79 0)
		else
			(++ local79)
		)
		(self
			x: 130
			y: 137
			setLoop: local79
			setMotion: PPath @local80 0 1 0 bString
		)
	)
)

(instance bString of Actor
	(properties
		x 130
		y 137
		view 888
	)

	(method (cue &tmp temp0)
		(if (== local79 4)
			(= local79 0)
		else
			(++ local79)
		)
		(self
			x: 130
			y: 137
			setLoop: local79
			setMotion: PPath @local80 0 1 0 aString
		)
	)
)

(instance buttonA of View
	(properties
		x 121
		y 146
		view 225
		loop 1
		cel 1
	)

	(method (doVerb)
		(if (!= cel 1)
			(return)
		)
		(if (== local78 12)
			(= local77 1)
			(robotJokes sel_623:)
		else
			(Print 220 17) ; "Sorry human. That is not the correct answer."
		)
	)
)

(instance buttonB of View
	(properties
		x 136
		y 146
		view 225
		loop 2
		cel 1
	)

	(method (doVerb)
		(if (!= cel 1)
			(return)
		)
		(if (== local78 16)
			(= local77 2)
			(robotJokes sel_623:)
		else
			(Print 220 17) ; "Sorry human. That is not the correct answer."
		)
	)
)

(instance buttonC of View
	(properties
		x 151
		y 146
		view 225
		loop 3
		cel 1
	)

	(method (doVerb)
		(if (!= cel 1)
			(return)
		)
		(if (== local78 0)
			(= local77 3)
			(robotJokes sel_623:)
		else
			(Print 220 17) ; "Sorry human. That is not the correct answer."
		)
	)
)

(instance buttonD of View
	(properties
		x 166
		y 146
		view 225
		loop 4
		cel 1
	)

	(method (doVerb)
		(if (!= cel 1)
			(return)
		)
		(if (== local78 8)
			(= local77 4)
			(robotJokes sel_623:)
		else
			(Print 220 17) ; "Sorry human. That is not the correct answer."
		)
	)
)

(instance buttonE of View
	(properties
		x 181
		y 146
		view 225
		loop 5
		cel 1
	)

	(method (doVerb)
		(if (!= cel 1)
			(return)
		)
		(if (== local78 4)
			(= local77 5)
			(robotJokes sel_623:)
		else
			(Print 220 17) ; "Sorry human. That is not the correct answer."
		)
	)
)

(instance buttonN of View
	(properties
		x 198
		y 146
		view 225
		loop 6
		cel 1
	)

	(method (doVerb &tmp temp0 temp1)
		(= temp1 1)
		(while temp1
			(if (< local78 16)
				(+= local78 4)
			else
				(= local78 0)
			)
			(switch (= temp0 (/ local78 4))
				(0
					(if (== [global403 0] 0)
						(= temp1 0)
					)
				)
				(1
					(if (== [global403 1] 0)
						(= temp1 0)
					)
				)
				(2
					(if (== [global403 2] 0)
						(= temp1 0)
					)
				)
				(3
					(if (== [global403 3] 0)
						(= temp1 0)
					)
				)
				(4
					(if (== [global403 4] 0)
						(= temp1 0)
					)
				)
			)
		)
		(localproc_0 local78)
		(super doVerb: &rest)
	)
)

(instance flashAnswer of Script
	(properties)

	(method (init)
		(gTheDoits add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc5_1)
				(bString hide: setMotion: 0)
				(aString
					setMotion: 0
					setLoop: (- local77 1)
					x: 130
					y: 115
					setCycle: Fwd
				)
				(= ticks 180)
			)
			(1
				(aString
					x: 130
					y: 137
					setCycle: 0
					setCel: 0
					setLoop: 0
					setMotion: PPath @local80 0 1 0 bString
				)
				(= local79 0)
				(bString show: x: 130 y: 137 setLoop: 1)
				(proc5_2)
				(= ticks 6)
			)
			(2
				(switch global114
					(0
						(if (== global175 3)
							(robotJokes solvePuzzle:)
						else
							(buttonN doVerb:)
						)
					)
					(1
						(if (== global175 4)
							(robotJokes solvePuzzle:)
						else
							(buttonN doVerb:)
						)
					)
					(2
						(if (== global175 5)
							(robotJokes solvePuzzle:)
						else
							(buttonN doVerb:)
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(class robotJokes of PuzzleBar
	(properties
		puzzleHeight 124
		bottomHeight 0
		solvedFlag 41
		sel_619 0
	)

	(method (init)
		(= sel_619 1)
		(switch global114
			(0
				(if (== global175 3)
					(SetFlag 41)
				)
			)
			(1
				(if (== global175 4)
					(SetFlag 41)
				)
			)
			(2
				(if (== global175 5)
					(SetFlag 41)
				)
			)
		)
		(if (IsFlag 41)
			(self dispose:)
		else
			(gTheIconBar disable: 0 2 3 4 5)
			(gCurRoom overlay: 221)
			(cButton setPri: 14 init:)
			(eButton setPri: 14 init:)
			(qButton setPri: 14 init:)
			(aString
				x: 130
				y: 137
				setPri: 11
				setLoop: 0
				ignoreActors: 1
				init:
				show:
				setMotion: PPath @local80 0 1 0 bString
			)
			(= local79 0)
			(bString
				x: 130
				y: 137
				setPri: 11
				setLoop: 1
				ignoreActors: 1
				show:
				init:
			)
			(if (or (== [global403 0] 1) (not (& global166 [local84 2])))
				(buttonC setCel: 2)
			)
			(if (or (== [global403 1] 1) (not (& global166 [local84 4])))
				(buttonE setCel: 2)
			)
			(if (or (== [global403 2] 1) (not (& global166 [local84 3])))
				(buttonD setCel: 2)
			)
			(if (or (== [global403 3] 1) (not (& global166 [local84 0])))
				(buttonA setCel: 2)
			)
			(if (or (== [global403 4] 1) (not (& global166 [local84 1])))
				(buttonB setCel: 2)
			)
			(= local78 16)
			(buttonN doVerb:)
			(buttonA setPri: 14 init:)
			(buttonB setPri: 14 init:)
			(buttonC setPri: 14 init:)
			(buttonD setPri: 14 init:)
			(buttonE setPri: 14 init:)
			(buttonN setPri: 14 init:)
		)
	)

	(method (dispose)
		(if (IsObject flashAnswer)
			(flashAnswer dispose:)
		)
		(aString dispose:)
		(bString dispose:)
		(buttonA dispose:)
		(buttonB dispose:)
		(buttonC dispose:)
		(buttonD dispose:)
		(buttonE dispose:)
		(buttonN dispose:)
		(cButton dispose:)
		(eButton dispose:)
		(qButton dispose:)
		(gCurRoom drawPic: 220)
		(gTheIconBar enable: 0 2 3 4 5)
		(if (IsFlag 41)
			(backDoor setScript: openBackDoor)
		)
		(= sel_619 0)
		(super dispose: &rest)
	)

	(method (sel_623)
		(switch local77
			(1
				(buttonA setCel: 2)
				(++ global175)
				(= [global403 3] 1)
			)
			(2
				(buttonB setCel: 2)
				(++ global175)
				(= [global403 4] 1)
			)
			(3
				(buttonC setCel: 2)
				(++ global175)
				(= [global403 0] 1)
			)
			(4
				(buttonD setCel: 2)
				(++ global175)
				(= [global403 2] 1)
			)
			(5
				(buttonE setCel: 2)
				(++ global175)
				(= [global403 1] 1)
			)
		)
		(self setScript: flashAnswer)
	)

	(method (solvePuzzle)
		(SetFlag 41)
		(self dispose:)
	)
)

(instance clueButtonSound of Sound ; UNUSED
	(properties
		flags 1
		number 58
	)
)

(instance nextButtonSound of Sound ; UNUSED
	(properties
		flags 1
		number 59
	)
)

(instance openButtonSound of Sound ; UNUSED
	(properties
		flags 1
		number 59
	)
)

(instance trashCan of Feature
	(properties
		x 121
		y 105
		nsTop 78
		nsLeft 105
		nsBottom 133
		nsRight 137
		description {trash can full of weapons}
		sightAngle 180
		lookStr {Dr. Brain doesn't believe in war or violence. That's why he threw out all these old weapons here.}
	)

	(method (doVerb theVerb)
		(cond
			((== 1 (robotJokes sel_619:))
				(return)
			)
			((== theVerb 3)
				(proc5_9 220 18)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ouchSound1 of Sound
	(properties
		flags 1
		number 958
	)
)

(instance ouchSound2 of Sound
	(properties
		flags 1
		number 959
	)
)

(instance spears of Feature
	(properties
		x 134
		y 132
		z 84
		nsTop 30
		nsLeft 116
		nsBottom 66
		nsRight 152
		description {spears}
		sightAngle 180
		lookStr {Those spears really look sharp.}
	)

	(method (doVerb theVerb)
		(cond
			((== 1 (robotJokes sel_619:))
				(return)
			)
			((== theVerb 3)
				(gCurRoom setScript: spearSound)
				(proc5_9 220 19)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spearSound of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (> (++ local76) 2)
					(ouchSound2 play: self)
					(= local76 0)
				else
					(ouchSound1 play: self)
				)
			)
			(1
				(if (maceHead cycler:)
					(gCMusic2 number: 221 flags: 1 setLoop: -1 play:)
				)
				(self dispose:)
			)
		)
	)
)

