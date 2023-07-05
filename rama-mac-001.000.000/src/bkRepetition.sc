;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4006)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Array)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	bkRepetition 0
	proc4006_1 1
)

(local
	local0
	[local1 18] = [9 8 3 7 4 2 12 5 8 14 4 9 2 0 6 1 5 7]
	local19
	[local20 18] = [15 56 24 83 72 33 24 77 42 50 110 83 22 56 32 49 29 18]
	local38
	[local39 9] = [12300 21540 31809 15000 26419 19555 31767 4276 10500]
	[local48 4] = [0 6 6 3]
	local52
	local53
	[local54 4] = [0 4003 4105 4205]
	[local58 4] = [0 4000 4100 4200]
	[local62 4] = [0 4002 4102 4202]
	[local66 4] = [0 4004 4104 4204]
	local70
	local71
)

(procedure (proc4006_1 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp2 (IntArray with: 0 0 0 0 0))
	(= temp1 param1)
	(for ((= temp0 param2)) (> temp0 0) ((-- temp0))
		(= temp3 (localproc_2 (QuesMgr base:) (- temp0 1)))
		(temp2 at: (- temp0 1) (/ temp1 temp3))
		(= temp1 (mod temp1 temp3))
	)
	(return temp2)
)

(procedure (localproc_0 param1)
	(return (not (mod param1 2)))
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2)
	(cond
		((QuesMgr givingDemo:)
			(if (== global269 2)
				(= temp0 4)
			else
				(= temp0 5)
			)
			(= temp2 12357)
		)
		((OneOf (QuesMgr numCorrect:) 0 1)
			(= temp0 1)
			(= temp1 [local48 1])
			(if param1
				(= local0 global270)
			else
				(= global270 (= local0 (mod local0 temp1)))
			)
			(= temp2 [local1 (+ local0 (* (- global269 1) temp1))])
			(++ local0)
		)
		((OneOf (QuesMgr numCorrect:) 2 3)
			(= temp0 2)
			(= temp1 [local48 2])
			(if param1
				(= local19 global270)
			else
				(= global270 (= local19 (mod local19 temp1)))
			)
			(= temp2 [local20 (+ local19 (* (- global269 1) temp1))])
			(++ local19)
		)
		((== (QuesMgr numCorrect:) 4)
			(if (== global269 2)
				(= temp0 4)
			else
				(= temp0 5)
			)
			(= temp1 [local48 3])
			(if param1
				(= local38 global270)
			else
				(= global270 (= local38 (mod local38 temp1)))
			)
			(= temp2 [local39 (+ local38 (* (- global269 1) temp1))])
			(++ local38)
		)
		(else
			(return)
		)
	)
	(++ local70)
	(QuesMgr display: temp2 temp0 setWaiting: 1)
	(AnswerMgr init:)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1)
	(= temp1 1)
	(for ((= temp0 1)) (<= temp0 param2) ((++ temp0))
		(*= temp1 param1)
	)
	(return temp1)
)

(instance bkRepetition of Location
	(properties
		exitStyle 256
	)

	(method (init)
		(= local0 (Random 0 5))
		(= local19 (Random 0 5))
		(= local38 (Random 0 2))
		(facePuzzle
			down: facePuzzleDown
			heading: (if (== global269 2) 90 else 270)
		)
		(facePuzzleDown heading: (if (== global269 2) 90 else 270))
		(super init: &rest)
		(= plane global116)
		(self addPicObj: facePuzzle)
		(LMACHINE_90 init:)
		(switch gPrevRoomNum
			(4004 ; bk1CountRm
				(= global269 1)
				(QuesMgr init: 10)
			)
			(4104 ; bk2Anteroom
				(= global269 2)
				(QuesMgr init: 16)
			)
			(4204 ; bk3Anteroom
				(= global269 3)
				(QuesMgr init: 8)
			)
		)
		(RemapColors 2 236 80) ; ByPercent
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
		(if (QuesMgr waiting:)
			(AnswerMgr check: param1)
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
		(self up: facePuzzle)
		(switch global269
			(1
				(= heading 270)
				(if (IsFlag 39)
					(= picture 4055)
				else
					(= picture 4008)
					(theHandle init: setHotspot: 2)
				)
			)
			(2
				(= heading 90)
				(if (IsFlag 40)
					(= picture 4112)
				else
					(= picture 4104)
					(theHandle init: setHotspot: 2)
				)
			)
			(3
				(= heading 270)
				(if (IsFlag 41)
					(= picture 4203)
				else
					(= picture 4204)
					(theHandle init: setHotspot: 2)
				)
			)
		)
		(oddSwitch init:)
		(super init: &rest)
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
			(= heading 90)
		else
			(= heading 270)
		)
		(= picture [local54 global269])
		(super init:)
	)
)

(instance theHandle of Feature
	(properties
		nsLeft 335
		nsTop 191
		nsRight 404
		nsBottom 234
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(switch global269
					(1
						(SetFlag 39)
						(gCurRoom drawPic: 4055)
						(doorOpenSnd play:)
					)
					(2
						(SetFlag 40)
						(gCurRoom drawPic: 4112)
						(doorOpenSnd play:)
					)
					(3
						(SetFlag 41)
						(gCurRoom drawPic: 4203)
						(doorOpenSnd play:)
					)
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class QuesMgr of Obj
	(properties
		numDigits 0
		theQues 0
		numCorrect 0
		waiting 0
		base 0
		givingDemo 0
	)

	(method (init param1)
		(if (== (gCurRoom picObj:) facePuzzle)
			(if (and argc param1)
				(= base param1)
			else
				(= base 10)
			)
			(= numCorrect global266)
			(super init: &rest)
			(if (> numCorrect -1)
				((ScriptID 4035 0) init: setActive: 1) ; LearningMachineKeys
				(localproc_1 1)
			else
				(self givingDemo: 1)
				(gCurRoom setScript: sGiveDemo)
			)
		)
	)

	(method (setWaiting param1)
		(= waiting param1)
	)

	(method (display param1 param2 &tmp temp0)
		(questionSnd play:)
		(= numDigits param2)
		(= theQues param1)
		(= temp0 (proc4006_1 theQues numDigits))
		(quesDigit5 cel: (temp0 at: 4) init:)
		(quesDigit4 cel: (temp0 at: 3) init:)
		(quesDigit3 cel: (temp0 at: 2) init:)
		(quesDigit2 cel: (temp0 at: 1) init:)
		(quesDigit1 cel: (temp0 at: 0) init:)
		(if (== global269 3)
			(quesIndicator init:)
		)
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
			(if (and numCorrect (localproc_0 numCorrect))
				(-- numCorrect)
			)
		)
	)

	(method (reset)
		(= numCorrect 0)
	)

	(method (hideAll)
		(= theQues (= numDigits (= waiting 0)))
		(quesDigit1 dispose:)
		(quesDigit2 dispose:)
		(quesDigit3 dispose:)
		(quesDigit4 dispose:)
		(quesDigit5 dispose:)
		(quesIndicator dispose:)
	)

	(method (dispose)
		(= numDigits (= base (= waiting (= numCorrect (= theQues 0)))))
		(super dispose: &rest)
	)
)

(class AnswerMgr of Obj
	(properties
		curAnswer 0
		digitCount 0
	)

	(method (init)
		(= curAnswer global245)
		(= digitCount global248)
		(= local71 (proc4006_1 curAnswer digitCount))
		(ansDigit5 init: global117)
		(ansDigit4 init: global117)
		(ansDigit3 init: global117)
		(ansDigit2 init: global117)
		(ansDigit1 init: global117)
		(super init:)
	)

	(method (hideAll)
		(= digitCount (= curAnswer 0))
		(= global245 curAnswer)
		(= global248 digitCount)
		(ansDigit1 dispose:)
		(ansDigit2 dispose:)
		(ansDigit3 dispose:)
		(ansDigit4 dispose:)
		(ansDigit5 dispose:)
		(ansIndicator dispose:)
	)

	(method (check param1)
		(ansDigit5 cel: (ansDigit4 cel:))
		(ansDigit4 cel: (ansDigit3 cel:))
		(ansDigit3 cel: (ansDigit2 cel:))
		(ansDigit2 cel: (ansDigit1 cel:))
		(ansDigit1 cel: param1)
		(UpdateScreenItem ansDigit1)
		(UpdateScreenItem ansDigit2)
		(UpdateScreenItem ansDigit3)
		(UpdateScreenItem ansDigit4)
		(UpdateScreenItem ansDigit5)
		(FrameOut)
		(*= curAnswer (QuesMgr base:))
		(+= curAnswer param1)
		(++ digitCount)
		(= global245 curAnswer)
		(= global248 digitCount)
		(if (== digitCount (QuesMgr numDigits:))
			(if (== global269 3)
				(ansIndicator init:)
			)
			(if (== curAnswer (QuesMgr theQues:))
				(gCurRoom setScript: sCorrectAnswer)
			else
				(gCurRoom setScript: sWrongAnswer)
			)
		)
	)

	(method (dispose)
		(ansDigit1 dispose:)
		(ansDigit2 dispose:)
		(ansDigit3 dispose:)
		(ansDigit4 dispose:)
		(ansDigit5 dispose:)
		(super dispose:)
	)
)

(instance sPromptUser of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local52 0)
				(= cycles 1)
			)
			(1
				(= seconds 12)
			)
			(2
				(if (== (AnswerMgr digitCount:) (QuesMgr numDigits:))
					(self dispose:)
				else
					(if (== local52 (AnswerMgr digitCount:))
						(questionSnd play:)
					)
					(= local52 (AnswerMgr digitCount:))
					(-= state 2)
					(= cycles 1)
				)
			)
		)
	)
)

(instance sGiveDemo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 2)
				(gGame handsOff:)
			)
			(1
				(localproc_1 0)
				(= seconds 1)
			)
			(2
				(= local52 (QuesMgr numDigits:))
				(= local53 (proc4006_1 (QuesMgr theQues:) local52))
				((ScriptID 4035 0) init:) ; LearningMachineKeys
				(= cycles 1)
			)
			(3
				((ScriptID 4035 0) showKeyDown: (local53 at: (- local52 1))) ; LearningMachineKeys
				(= seconds 1)
			)
			(4
				((ScriptID 4035 0) showKeyUp:) ; LearningMachineKeys
				(if (-- local52)
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
				(ansDigit1 dispose:)
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
				(if (QuesMgr givingDemo:)
					(sGiveDemo dispose:)
					((ScriptID 4035 0) showKeyUp:) ; LearningMachineKeys
				)
				(QuesMgr incCorrect:)
				(= global266 (QuesMgr numCorrect:))
				(= local70 0)
				(= cycles 1)
			)
			(2
				(QuesMgr hideAll:)
				(AnswerMgr hideAll:)
				(theReward view: [local62 global269] init: global117)
				(correctSnd play: self)
			)
			(3
				(= cycles 80)
			)
			(4
				(theReward dispose:)
				(ansDigit1 init: global117)
				(if (QuesMgr givingDemo:)
					((ScriptID 4035 0) setActive: 1) ; LearningMachineKeys
					(QuesMgr givingDemo: 0)
				)
				(= cycles 90)
			)
			(5
				(if (< (QuesMgr numCorrect:) 5)
					(gGame handsOn:)
					(localproc_1 0)
					(self dispose:)
				else
					(QuesMgr reset:)
					(= global266 (QuesMgr numCorrect:))
					(= global270 0)
					(QuesMgr dispose:)
					(AnswerMgr dispose:)
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

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(QuesMgr hideAll:)
				(if (>= local70 3)
					(QuesMgr decCorrect:)
					(= global266 (QuesMgr numCorrect:))
					(= local70 0)
				)
				(AnswerMgr hideAll:)
				(wrongSnd play: self)
				(theReward view: [local66 global269] init: global117)
				(FrameOut)
			)
			(2
				(= cycles 80)
			)
			(3
				(theReward dispose:)
				(gGame handsOn:)
				(localproc_1 0)
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
		(= view [local58 global269])
		(super init: global117 &rest)
	)
)

(instance theReward of View
	(properties
		x 62
		y 32
	)

	(method (init)
		(self ignoreActors: 1)
		(= priority 255)
		(super init: global117 &rest)
	)
)

(class QuesDigit of View
	(properties
		y 110
		loop 2
	)

	(method (init)
		(= view [local58 global269])
		(super init: &rest)
	)
)

(instance quesDigit1 of QuesDigit
	(properties)

	(method (init &tmp temp0)
		(switch (QuesMgr numDigits:)
			(1
				(= x 157)
			)
			(2
				(= x (quesDigit2 nsRight:))
			)
			(4
				(= x (quesDigit2 nsRight:))
			)
			(5
				(= x (quesDigit2 nsRight:))
			)
		)
		(super init: global117)
	)
)

(instance quesDigit2 of QuesDigit
	(properties)

	(method (init)
		(switch (QuesMgr numDigits:)
			(2
				(if (== global269 3)
					(= x 154)
				else
					(= x 134)
				)
				(super init: global117)
			)
			(4
				(= x (quesDigit3 nsRight:))
				(super init: global117)
			)
			(5
				(= x (quesDigit3 nsRight:))
				(super init: global117)
			)
		)
	)
)

(instance quesDigit3 of QuesDigit
	(properties)

	(method (init)
		(switch (QuesMgr numDigits:)
			(4
				(= x (quesDigit4 nsRight:))
				(super init: global117)
			)
			(5
				(= x (quesDigit4 nsRight:))
				(super init: global117)
			)
		)
	)
)

(instance quesDigit4 of QuesDigit
	(properties)

	(method (init)
		(switch (QuesMgr numDigits:)
			(4
				(= x 120)
				(super init: global117)
			)
			(5
				(= x (quesDigit5 nsRight:))
				(super init: global117)
			)
		)
	)
)

(instance quesDigit5 of QuesDigit
	(properties)

	(method (init)
		(switch (QuesMgr numDigits:)
			(5
				(if (== global269 3)
					(= x 130)
				else
					(= x 105)
				)
				(super init: global117)
			)
		)
	)
)

(instance quesIndicator of QuesDigit
	(properties
		loop 4
		cel 4
	)

	(method (init)
		(switch (QuesMgr numDigits:)
			(1
				(= x (- (quesDigit1 nsLeft:) 10))
				(super init: global117)
			)
			(2
				(= x (- (quesDigit2 nsLeft:) 10))
				(super init: global117)
			)
			(5
				(= x (- (quesDigit5 nsLeft:) 10))
				(super init: global117)
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
		(self ignoreActors: 1)
		(= view [local58 global269])
		(super init: &rest)
	)
)

(instance ansDigit1 of AnsDigit
	(properties)

	(method (init)
		(switch (QuesMgr numDigits:)
			(1
				(= x 159)
			)
			(2
				(= x (ansDigit2 nsRight:))
			)
			(4
				(= x (ansDigit2 nsRight:))
			)
			(5
				(= x (ansDigit2 nsRight:))
			)
			(else
				(= x (ansDigit2 nsRight:))
			)
		)
		(if (>= (AnswerMgr digitCount:) 1)
			(= cel (local71 at: 0))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance ansDigit2 of AnsDigit
	(properties)

	(method (init)
		(switch (QuesMgr numDigits:)
			(2
				(if (== global269 3)
					(= x 158)
				else
					(= x 144)
				)
			)
			(4
				(= x (ansDigit3 nsRight:))
			)
			(5
				(= x (ansDigit3 nsRight:))
			)
			(else
				(= x (ansDigit3 nsRight:))
			)
		)
		(super init: global117)
		(if (>= (AnswerMgr digitCount:) 2)
			(= cel (local71 at: 1))
		else
			(= cel 16)
		)
	)
)

(instance ansDigit3 of AnsDigit
	(properties)

	(method (init)
		(switch (QuesMgr numDigits:)
			(4
				(= x (ansDigit4 nsRight:))
			)
			(5
				(= x (ansDigit4 nsRight:))
			)
			(else
				(= x 0)
			)
		)
		(if (>= (AnswerMgr digitCount:) 3)
			(= cel (local71 at: 2))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance ansDigit4 of AnsDigit
	(properties)

	(method (init)
		(switch (QuesMgr numDigits:)
			(4
				(= x 120)
			)
			(5
				(= x (ansDigit5 nsRight:))
			)
			(else
				(= x 0)
			)
		)
		(if (>= (AnswerMgr digitCount:) 4)
			(= cel (local71 at: 3))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance ansDigit5 of AnsDigit
	(properties)

	(method (init)
		(switch (QuesMgr numDigits:)
			(5
				(if (== global269 3)
					(= x 136)
				else
					(= x 120)
				)
			)
			(else
				(= x 0)
			)
		)
		(if (>= (AnswerMgr digitCount:) 5)
			(= cel (local71 at: 4))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance ansIndicator of View
	(properties
		y 227
		loop 4
		cel 5
	)

	(method (init)
		(= view [local58 global269])
		(switch (QuesMgr numDigits:)
			(1
				(= x (- (ansDigit1 nsLeft:) 10))
			)
			(2
				(= x (- (ansDigit2 nsLeft:) 10))
			)
			(4
				(PrintDebug
					{ERROR ansIndicator shouldn't be used with 4 digits!}
				)
			)
			(5
				(= x (- (ansDigit5 nsLeft:) 10))
			)
		)
		(super init: global117)
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
		exitStyle 256
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

(instance doorOpenSnd of Sound
	(properties
		flags 5
		number 4013
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

(instance oddSwitch of Feature
	(properties
		noun 26
		nsLeft 35
		nsTop 91
		nsRight 404
		nsBottom 234
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

