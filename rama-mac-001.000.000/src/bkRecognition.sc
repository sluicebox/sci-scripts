;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4007)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Array)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	bkRecognition 0
)

(local
	local0
	local1
	[local2 18] = [3 6 2 8 5 9 4 7 11 15 3 10 6 5 3 1 7 4]
	local20
	[local21 18] = [10 43 34 64 27 81 16 72 23 36 112 99 11 22 33 44 55 63]
	local39
	[local40 9] = [100 115 109 83 111 22 66 77 110]
	[local49 4] = [0 6 6 3]
	local53
	local54
	[local55 4] = [0 4003 4105 4205]
	[local59 4] = [0 4000 4100 4200]
	[local63 4] = [0 4002 4102 4202]
	[local67 4] = [0 4004 4104 4204]
	local71
	local72
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(= temp1 1)
	(for ((= temp0 1)) (<= temp0 param2) ((++ temp0))
		(*= temp1 param1)
	)
	(return temp1)
)

(procedure (localproc_1 param1)
	(return (not (mod param1 2)))
)

(procedure (localproc_2 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= temp2 (IntArray with: 0 0 0 0 0))
	(= temp1 param1)
	(for ((= temp0 param2)) (> temp0 0) ((-- temp0))
		(= temp3 (localproc_0 param3 (- temp0 1)))
		(temp2 at: (- temp0 1) (/ temp1 temp3))
		(= temp1 (mod temp1 temp3))
	)
	(return temp2)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2)
	(cond
		((RecogQues givingDemo:)
			(if (== global269 2)
				(= temp0 2)
			else
				(= temp0 3)
			)
			(= temp2 116)
		)
		((OneOf (RecogQues numCorrect:) 0 1)
			(= temp0 1)
			(= temp1 [local49 1])
			(if param1
				(= local1 global271)
			else
				(= global271 (= local1 (mod local1 temp1)))
			)
			(= temp2 [local2 (+ local1 (* (- global269 1) temp1))])
			(++ local1)
		)
		((OneOf (RecogQues numCorrect:) 2 3)
			(= temp0 2)
			(= temp1 [local49 2])
			(if param1
				(= local20 global271)
			else
				(= global271 (= local20 (mod local20 temp1)))
			)
			(= temp2 [local21 (+ local20 (* (- global269 1) temp1))])
			(++ local20)
		)
		((== (RecogQues numCorrect:) 4)
			(= temp0 (if (== global269 2) 2 else 3))
			(= temp1 [local49 3])
			(if param1
				(= local39 global271)
			else
				(= global271 (= local39 (mod local39 temp1)))
			)
			(= temp2 [local40 (+ local39 (* (- global269 1) temp1))])
			(++ local39)
		)
		(else
			(return)
		)
	)
	(++ local71)
	(RecogQues display: temp2 temp0)
)

(instance bkRecognition of Location
	(properties
		exitStyle 256
	)

	(method (init)
		(facePuzzle
			down: facePuzzleDown
			heading: (if (== global269 2) 90 else 270)
		)
		(facePuzzleDown heading: (if (== global269 2) 90 else 270))
		(super init: &rest)
		(= plane global116)
		(self addPicObj: facePuzzle)
		(RemapColors 2 236 90) ; ByPercent
		(= local1 (Random 0 5))
		(= local20 (Random 0 5))
		(= local39 (Random 0 2))
		(switch gPrevRoomNum
			(4004 ; bk1CountRm
				(RecogQues init: 10)
			)
			(4104 ; bk2Anteroom
				(RecogQues init: 16)
			)
			(4204 ; bk3Anteroom
				(RecogQues init: 8)
			)
		)
		(LMACHINE_90 init:)
	)

	(method (pitch param1)
		(switch param1
			(1
				(= global164 0)
				(self newRoom: gPrevRoomNum)
			)
			(-1
				(= global164 180)
				(self setPicObj: facePuzzle)
			)
		)
	)

	(method (notify param1)
		(if (RecogQues waiting:)
			(TheAnswer check: param1)
		)
	)
)

(instance facePuzzleDown of CameraAngle
	(properties
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(thePanel dispose:)
		(switch global269
			(1
				(= picture 4004)
				(self heading: 270)
			)
			(2
				(self heading: 90)
				(= picture 4106)
				(if (== (proc70_9 37) 4007)
					(hTalisman init: global117 setHotspot: 2)
				)
			)
			(3
				(self heading: 270)
				(= picture 4206)
				(if (== (proc70_9 104) 4007)
					(oTalisman init: global117 setHotspot: 2)
				)
			)
		)
		(self up: facePuzzle)
		(super init: &rest)
		(if (and (== global269 1) (proc1111_24 48))
			(proc1111_31 18)
			(SetFlag 48)
		)
	)
)

(instance facePuzzle of CameraAngle
	(properties
		edgeN 0
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(backupExit init:)
		(if (== global164 180)
			(gGame handsOff:)
			(thePanel cel: 0 init: global117 setCycle: End thePanel)
			(= global164 0)
			(facePuzzleDown up: 0)
			(facePuzzle down: 0)
		)
		(if (== global269 2)
			(self heading: 90)
		else
			(self heading: 270)
		)
		(= picture [local55 global269])
		(super init: &rest)
	)
)

(class RecogQues of Obj
	(properties
		left 75
		top 57
		xspace 17
		yspace 15
		givingDemo 0
		numDots 0
		numDigits 0
		numCorrect 0
		waiting 0
		base 0
	)

	(method (init param1)
		(if (== (gCurRoom picObj:) facePuzzle)
			(if (and argc param1)
				(= base param1)
			else
				(= base 10)
			)
			(= numCorrect global267)
			(super init: &rest)
			(if (> numCorrect -1)
				((ScriptID 4035 0) init:) ; LearningMachineKeys
				(localproc_3 1)
			else
				(self givingDemo: 1)
				(gCurRoom setScript: sPlayBall)
			)
		)
	)

	(method (display param1 param2 &tmp temp0 temp1 temp2)
		(= numDots param1)
		(= numDigits param2)
		(TheAnswer init:)
		(= temp1 left)
		(= temp2 top)
		(= local0 (List new:))
		(= temp1 left)
		(= temp2 top)
		(for ((= temp0 1)) (<= temp0 numDots) ((++ temp0))
			(local0 add: ((dot new:) x: temp1 y: temp2 yourself:))
			(+= temp1 xspace)
			(if (not (mod temp0 11))
				(+= temp2 yspace)
				(= temp1 left)
			)
		)
		(questionSnd play:)
		(local0 eachElementDo: #init global117)
		(FrameOut)
		(= waiting 1)
		((ScriptID 4035 0) setActive: 1) ; LearningMachineKeys
		(if (not givingDemo)
			(gCurRoom setScript: sPromptUser)
		)
	)

	(method (incCorrect)
		(++ numCorrect)
	)

	(method (decCorrect)
		(if numCorrect
			(-- numCorrect)
			(if (and numCorrect (localproc_1 numCorrect))
				(-- numCorrect)
			)
		)
	)

	(method (reset)
		(= numDigits (= numDots (= numCorrect 0)))
	)

	(method (hideAll)
		(= waiting (= numDigits (= numDots 0)))
		(local0 eachElementDo: #dispose)
	)
)

(class TheAnswer of Obj
	(properties
		curAnswer 0
		digitCount 0
	)

	(method (init)
		(= curAnswer global246)
		(= digitCount global249)
		(= local72 (localproc_2 curAnswer digitCount (RecogQues base:)))
		(digit3 init: global117)
		(digit2 init: global117)
		(digit1 init: global117)
		(super init:)
	)

	(method (hideAll)
		(= curAnswer (= global246 0))
		(= digitCount (= global249 0))
		(digit1 dispose:)
		(digit2 dispose:)
		(digit3 dispose:)
		(ansIndicator dispose:)
	)

	(method (check param1)
		(digit3 cel: (digit2 cel:))
		(digit2 cel: (digit1 cel:))
		(digit1 cel: param1)
		(UpdateScreenItem digit1)
		(UpdateScreenItem digit2)
		(UpdateScreenItem digit3)
		(FrameOut)
		(*= curAnswer (RecogQues base:))
		(+= curAnswer param1)
		(++ digitCount)
		(= global246 curAnswer)
		(= global249 digitCount)
		(if (== digitCount (RecogQues numDigits:))
			(if (== global269 3)
				(ansIndicator init: global117)
			)
			(if (== curAnswer (RecogQues numDots:))
				(gCurRoom setScript: sCorrectAnswer)
			else
				(gCurRoom setScript: sWrongAnswer)
			)
		)
	)

	(method (dispose)
		(digit1 dispose:)
		(digit2 dispose:)
		(digit3 dispose:)
		(super dispose:)
	)
)

(instance sPromptUser of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local53 0)
				(= cycles 1)
			)
			(1
				(= seconds 12)
			)
			(2
				(if (== (TheAnswer digitCount:) (RecogQues numDigits:))
					(self dispose:)
				else
					(if (== local53 (TheAnswer digitCount:))
						(questionSnd play:)
					)
					(= local53 (TheAnswer digitCount:))
					(-= state 2)
					(= cycles 1)
				)
			)
		)
	)
)

(instance sPlayBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(localproc_3 0)
				(= cycles 1)
			)
			(2
				(= local53 (RecogQues numDigits:))
				(= local54
					(localproc_2 (RecogQues numDots:) local53 (RecogQues base:))
				)
				((ScriptID 4035 0) init:) ; LearningMachineKeys
				(= cycles 1)
			)
			(3
				((ScriptID 4035 0) showKeyDown: (local54 at: (- local53 1))) ; LearningMachineKeys
				(= seconds 1)
			)
			(4
				((ScriptID 4035 0) showKeyUp:) ; LearningMachineKeys
				(if (-- local53)
					(-= state 2)
				)
				(= cycles 30)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sLookAtPuzzle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
				(facePuzzle down: facePuzzleDown)
				(facePuzzleDown up: facePuzzle)
			)
			(1
				(thePanel cel: 11 init: global117 setCycle: Beg self)
				(digit1 dispose:)
			)
			(2
				(gCurRoom setPicObj: facePuzzleDown)
				(self dispose:)
			)
		)
	)
)

(instance sCorrectAnswer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(if (RecogQues givingDemo:)
					(sPlayBall dispose:)
					((ScriptID 4035 0) showKeyUp:) ; LearningMachineKeys
				)
				(RecogQues incCorrect:)
				(= global267 (RecogQues numCorrect:))
				(= local71 0)
				(= cycles 1)
			)
			(2
				(RecogQues hideAll:)
				(TheAnswer hideAll:)
				(theReward view: [local63 global269] init: global117)
				(correctSnd play: self)
			)
			(3
				(= cycles 80)
			)
			(4
				(theReward dispose:)
				(digit1 init: global117)
				(if (RecogQues givingDemo:)
					((ScriptID 4035 0) setActive: 1) ; LearningMachineKeys
					(RecogQues givingDemo: 0)
				)
				(= cycles 90)
			)
			(5
				(if (< (RecogQues numCorrect:) 5)
					(localproc_3 0)
					(gGame handsOn:)
					(self dispose:)
				else
					(RecogQues reset:)
					(= global267 (RecogQues numCorrect:))
					(RecogQues dispose:)
					(TheAnswer dispose:)
					((ScriptID 4035 0) dispose:) ; LearningMachineKeys
					(self setScript: sLookAtPuzzle self)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWrongAnswer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(RecogQues hideAll:)
				(if (>= local71 3)
					(RecogQues decCorrect:)
					(= global267 (RecogQues numCorrect:))
					(= local71 0)
				)
				(TheAnswer hideAll:)
				(wrongSnd play: self)
				(theReward view: [local67 global269] init: global117)
				(FrameOut)
			)
			(2
				(= cycles 80)
			)
			(3
				(theReward dispose:)
				(localproc_3 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance thePanel of Prop
	(properties
		x 2
		y 290
		loop 1
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (init)
		(= view [local59 global269])
		(super init: global117 &rest)
	)
)

(instance hTalisman of View
	(properties
		x 237
		y 164
		view 4103
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 37)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance oTalisman of View
	(properties
		x 247
		y 165
		view 4203
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 104)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class AnsDigit of View
	(properties
		y 227
		loop 3
	)

	(method (init)
		(= view [local59 global269])
		(super init: &rest)
	)
)

(instance ansIndicator of View
	(properties
		y 227
		loop 4
		cel 5
	)

	(method (init)
		(= view [local59 global269])
		(switch (RecogQues numDigits:)
			(1
				(= x (- (digit1 nsLeft:) 10))
			)
			(2
				(= x (- (digit2 nsLeft:) 10))
			)
			(3
				(= x (- (digit3 nsLeft:) 10))
			)
		)
		(super init: global117)
	)
)

(instance digit1 of AnsDigit
	(properties)

	(method (init)
		(switch (RecogQues numDigits:)
			(1
				(= x 159)
			)
			(2
				(= x (digit2 nsRight:))
			)
			(3
				(= x (digit2 nsRight:))
			)
			(else
				(= x 0)
			)
		)
		(if (>= (TheAnswer digitCount:) 1)
			(= cel (local72 at: 0))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance digit2 of AnsDigit
	(properties)

	(method (init)
		(switch (RecogQues numDigits:)
			(2
				(= x 147)
			)
			(3
				(= x (digit3 nsRight:))
			)
			(else
				(= x 0)
			)
		)
		(if (>= (TheAnswer digitCount:) 2)
			(= cel (local72 at: 1))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance digit3 of AnsDigit
	(properties)

	(method (init)
		(switch (RecogQues numDigits:)
			(3
				(= x 140)
			)
			(else
				(= x 0)
			)
		)
		(if (>= (TheAnswer digitCount:) 3)
			(= cel (local72 at: 2))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance dot of View
	(properties
		loop 4
	)

	(method (init)
		(= view [local59 global269])
		(super init: &rest)
	)
)

(instance theReward of View
	(properties
		x 62
		y 32
	)
)

(instance questionSnd of Sound
	(properties
		flags 5
	)

	(method (init)
		(switch global269
			(1
				(= number 4000)
			)
			(2
				(= number 4100)
			)
			(3
				(= number 4200)
			)
		)
		(super init: &rest)
	)
)

(instance correctSnd of Sound
	(properties
		flags 5
	)

	(method (init)
		(switch global269
			(1
				(= number 4001)
			)
			(2
				(= number 4101)
			)
			(3
				(= number 4201)
			)
		)
		(super init: &rest)
	)
)

(instance wrongSnd of Sound
	(properties
		flags 5
	)

	(method (init)
		(switch global269
			(1
				(= number 4002)
			)
			(2
				(= number 4102)
			)
			(3
				(= number 4202)
			)
		)
		(super init: &rest)
	)
)

(instance backupCursor of View
	(properties
		view 600
		cel 5
	)
)

(instance backupExit of ExitFeature
	(properties
		nsLeft 89
		nsTop 254
		nsRight 461
		nsBottom 289
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: backupCursor)
			)
			(else
				(if gVMDMovie
					(gVMDMovie mouseDownAction: 1)
				)
				(gCurRoom pitch: 1)
			)
		)
	)
)

(instance LMACHINE_90 of Feature
	(properties
		nsLeft 21
		nsTop 10
		nsRight 568
		nsBottom 276
	)

	(method (init)
		(switch global269
			(1
				(= noun 9)
			)
			(2
				(= noun 22)
			)
			(3
				(= noun 40)
			)
		)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

