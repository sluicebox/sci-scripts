;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4008)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Array)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	bkManipulation 0
)

(local
	[local0 4] = [0 4003 4105 4205]
	[local4 4] = [0 4000 4100 4200]
	[local8 4] = [0 4002 4102 4202]
	[local12 4] = [0 4004 4104 4204]
	[local16 9] = [1 3 8 14 7 10 3 2 7]
	[local25 18] = [5 4 1 1 5 4 1 4 0 6 7 9 15 12 14 4 6 7]
	[local43 9] = [8 4 1 13 5 15 3 5 7]
	[local52 18] = [5 4 0 11 4 5 1 4 2 3 0 0 2 1 10 2 1 5]
	[local70 9] = [36 43 73 36 88 108 34 24 47]
	[local79 18] = [63 21 12 18 167 49 16 13 8 99 64 85 54 255 157 50 37 55]
	[local97 9] = [79 83 56 218 255 62 62 42 63]
	[local106 18] = [16 51 14 90 170 44 25 33 38 83 32 42 128 85 18 37 9 35]
	[local124 9] = [16234 12070 10997 8000 9999 6984 4099 7999 5675]
	[local133 18] = [11476 19621 11766 23183 15766 21403 7679 5236 7909 27710 31691 22763 31183 25865 28387 11778 13235 13584]
	local151
	local152
	local153
	local154
	local155
	local156
	local157
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp2 (IntArray with: 0 0 0 0 0))
	(= temp1 param1)
	(for ((= temp0 param2)) (> temp0 0) ((-- temp0))
		(= temp3 (localproc_1 (ManipQues base:) (- temp0 1)))
		(temp2 at: (- temp0 1) (/ temp1 temp3))
		(= temp1 (mod temp1 temp3))
	)
	(return temp2)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1)
	(= temp1 1)
	(for ((= temp0 1)) (<= temp0 param2) ((++ temp0))
		(*= temp1 param1)
	)
	(return temp1)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(cond
		((ManipQues givingDemo:)
			(if (== global269 2)
				(= temp0 4)
			else
				(= temp0 5)
			)
			(= temp1 16749)
			(= temp2 14351)
			(= temp3 3)
		)
		((== (ManipQues numCorrect:) 0)
			(if param1
				(= local151 global272)
			else
				(= global272 (= local151 (mod local151 3)))
			)
			(= temp1 [local16 (+ local151 (* (- global269 1) 3))])
			(= temp2 [local25 (+ local151 (* (- global269 1) 3))])
			(= temp3 3)
			(= temp0 1)
			(++ local151)
		)
		((== (ManipQues numCorrect:) 1)
			(if param1
				(= local151 global272)
			else
				(= global272 (= local151 (mod local151 3)))
			)
			(= temp1 [local43 (+ local151 (* (- global269 1) 3))])
			(= temp2 [local52 (+ local151 (* (- global269 1) 3))])
			(= temp3 2)
			(= temp0 1)
			(++ local151)
		)
		((== (ManipQues numCorrect:) 2)
			(if param1
				(= local152 global272)
			else
				(= global272 (= local152 (mod local152 3)))
			)
			(= temp1 [local70 (+ local152 (* (- global269 1) 3))])
			(= temp2 [local79 (+ local152 (* (- global269 1) 3))])
			(= temp3 3)
			(= temp0 2)
			(++ local152)
		)
		((== (ManipQues numCorrect:) 3)
			(if param1
				(= local152 global272)
			else
				(= global272 (= local152 (mod local152 3)))
			)
			(= temp1 [local97 (+ local152 (* (- global269 1) 3))])
			(= temp2 [local106 (+ local152 (* (- global269 1) 3))])
			(= temp3 2)
			(= temp0 2)
			(++ local152)
		)
		((== (ManipQues numCorrect:) 4)
			(if param1
				(= local153 global272)
			else
				(= global272 (= local153 (mod local153 3)))
			)
			(= temp1 [local124 (+ local153 (* (- global269 1) 3))])
			(= temp2 [local133 (+ local153 (* (- global269 1) 3))])
			(= temp3 3)
			(if (== global269 2)
				(= temp0 4)
			else
				(= temp0 5)
			)
			(++ local153)
		)
		(else
			(PrintDebug
				{Wrong number of correct answers: %d}
				(ManipQues numCorrect:)
			)
		)
	)
	(++ local156)
	(ManipQues displayQues: temp1 temp2 temp3 temp0 setWaiting: 1)
	(AnsManager init:)
)

(instance bkManipulation of Location
	(properties
		exitStyle 256
	)

	(method (init)
		(facePuzzle
			down: facePuzzleDown
			heading: (if (== global269 2) 90 else 270)
		)
		(facePuzzleDown heading: (if (== global269 2) 90 else 270))
		(super init:)
		(= plane global116)
		(self addPicObj: facePuzzle)
		(switch gPrevRoomNum
			(4004 ; bk1CountRm
				(= global269 1)
				(ManipQues init: 10)
			)
			(4104 ; bk2Anteroom
				(= global269 2)
				(ManipQues init: 16)
			)
			(4204 ; bk3Anteroom
				(= global269 3)
				(ManipQues init: 8)
			)
		)
		(RemapColors 2 236 80) ; ByPercent
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
		(if (ManipQues waiting:)
			(AnsManager check: param1)
		)
	)
)

(instance facePuzzleDown of CameraAngle
	(properties
		edgeW 0
		edgeE 0
		edgeS 0
	)

	(method (init)
		(self up: facePuzzle)
		(thePanel dispose:)
		(switch global269
			(1
				(= heading 270)
				(= picture 4006)
			)
			(2
				(= heading 90)
				(= picture 4108)
			)
			(3
				(= heading 270)
				(= picture 4208)
			)
		)
		(theJewel init:)
		(super init: &rest)
	)
)

(instance facePuzzle of CameraAngle
	(properties
		edgeW 0
		edgeE 0
		edgeS 0
		edgeN 0
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
		(switch global269
			(1
				(self heading: 270)
				(= picture 4003)
			)
			(2
				(self heading: 90)
				(= picture 4105)
			)
			(3
				(self heading: 270)
				(= picture 4205)
			)
		)
		(super init: &rest)
	)
)

(class ManipQues of Obj
	(properties
		waiting 0
		base 0
		theAns 0
		numCorrect -1
		numDigits 0
		operand1 0
		operand2 0
		theOp 0
		givingDemo 0
	)

	(method (setWaiting param1)
		(= waiting param1)
	)

	(method (init param1)
		(if (== (gCurRoom picObj:) facePuzzle)
			(if (and argc param1)
				(= base param1)
			else
				(= base 10)
			)
			(= numCorrect global268)
			(PrintDebug {gLM3Ques %d} global268)
			(super init: &rest)
			(if (!= numCorrect -1)
				((ScriptID 4035 0) init:) ; LearningMachineKeys
				(localproc_2 1)
			else
				(self givingDemo: 1)
				(gCurRoom setScript: sGiveDemo)
			)
		)
	)

	(method (displayQues param1 param2 param3 param4 &tmp temp0 temp1)
		(= operand1 param1)
		(= operand2 param2)
		(= numDigits param4)
		(= theOp param3)
		(switch theOp
			(3
				(= theAns (+ operand1 operand2))
			)
			(2
				(= theAns (- operand1 operand2))
			)
		)
		(= waiting 0)
		(= temp0 (localproc_0 operand1 numDigits))
		(= temp1 (localproc_0 operand2 numDigits))
		(questionSnd play:)
		(quesDigit5 cel: (temp0 at: 4) init: global117)
		(quesDigit4 cel: (temp0 at: 3) init: global117)
		(quesDigit3 cel: (temp0 at: 2) init: global117)
		(quesDigit2 cel: (temp0 at: 1) init: global117)
		(quesDigit1 cel: (temp0 at: 0) init: global117)
		(operator cel: theOp init: global117)
		(quesDigit10 cel: (temp1 at: 4) init: global117)
		(quesDigit9 cel: (temp1 at: 3) init: global117)
		(quesDigit8 cel: (temp1 at: 2) init: global117)
		(quesDigit7 cel: (temp1 at: 1) init: global117)
		(quesDigit6 cel: (temp1 at: 0) init: global117)
		(equalSign init: global117)
		(if (== global269 3)
			(quesIndicator1 init:)
			(quesIndicator2 init:)
		)
		(= waiting 1)
		((ScriptID 4035 0) active: 1) ; LearningMachineKeys
		(if (not givingDemo)
			(gCurRoom setScript: sPromptUser)
		)
	)

	(method (incNumCorrect)
		(++ numCorrect)
	)

	(method (hideAll)
		(= theAns (= numDigits (= waiting 0)))
		(quesDigit1 dispose:)
		(quesDigit2 dispose:)
		(quesDigit3 dispose:)
		(quesDigit4 dispose:)
		(quesDigit5 dispose:)
		(quesDigit6 dispose:)
		(quesDigit7 dispose:)
		(quesDigit8 dispose:)
		(quesDigit9 dispose:)
		(quesDigit10 dispose:)
		(quesIndicator1 dispose:)
		(quesIndicator2 dispose:)
		(operator dispose:)
		(equalSign dispose:)
	)

	(method (dispose)
		(= numDigits (= base (= waiting (= numCorrect (= theAns 0)))))
		(super dispose: &rest)
	)
)

(class AnsManager of Obj
	(properties
		curAnswer 0
		digitCount 0
	)

	(method (init)
		(= curAnswer global247)
		(= digitCount global207)
		(= local157 (localproc_0 curAnswer digitCount))
		(ansDigit5 init: global117)
		(ansDigit4 init: global117)
		(ansDigit3 init: global117)
		(ansDigit2 init: global117)
		(ansDigit1 init: global117)
		(super init: &rest)
	)

	(method (hideAll)
		(= digitCount (= curAnswer 0))
		(= global247 curAnswer)
		(= global207 digitCount)
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
		(*= curAnswer (ManipQues base:))
		(+= curAnswer param1)
		(++ digitCount)
		(= global247 curAnswer)
		(= global207 digitCount)
		(if (== digitCount (ManipQues numDigits:))
			(if (== global269 3)
				(ansIndicator init:)
			)
			(if (== curAnswer (ManipQues theAns:))
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

(instance theJewel of View
	(properties
		x 253
		y 143
		cel 1
	)

	(method (init &tmp temp0)
		(switch global269
			(1
				(= view 4003)
				(= temp0 41)
			)
			(2
				(= view 4103)
				(= temp0 42)
			)
			(3
				(= view 4203)
				(= temp0 43)
			)
		)
		(if (== (proc70_9 temp0) 4008)
			(super init: global117 &rest)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(switch global269
					(1
						(= temp0 41)
					)
					(2
						(= temp0 42)
					)
					(3
						(= temp0 43)
					)
				)
				(self hide:)
				(proc70_1 temp0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class QuesDigits of View
	(properties
		loop 2
	)

	(method (init)
		(self ignoreActors: 1)
		(= view [local4 global269])
		(super init: &rest)
	)
)

(instance quesDigit10 of QuesDigits
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(5
				(= x (quesDigit5 x:))
				(= y 150)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance quesDigit9 of QuesDigits
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(4
				(= x (quesDigit4 x:))
				(= y 150)
			)
			(5
				(= x (quesDigit10 nsRight:))
				(= y 150)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance quesDigit8 of QuesDigits
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(4
				(= x (quesDigit9 nsRight:))
				(= y 150)
			)
			(5
				(= x (quesDigit9 nsRight:))
				(= y 150)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance quesDigit7 of QuesDigits
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(2
				(= x (+ (operator nsRight:) 10))
				(= y 113)
			)
			(4
				(= x (quesDigit8 nsRight:))
				(= y 150)
			)
			(5
				(= x (quesDigit8 nsRight:))
				(= y 150)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance quesDigit6 of QuesDigits
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(1
				(= x (+ (operator nsRight:) 10))
				(= y 113)
			)
			(2
				(= x (quesDigit7 nsRight:))
				(= y 113)
			)
			(4
				(= x (quesDigit7 nsRight:))
				(= y 150)
			)
			(5
				(= x (quesDigit7 nsRight:))
				(= y 150)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance quesDigit5 of QuesDigits
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(5
				(if (== global269 3)
					(= x 120)
				else
					(= x 90)
				)
				(= y 80)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance quesDigit4 of QuesDigits
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(4
				(= y (= x 100))
			)
			(5
				(= x (quesDigit5 nsRight:))
				(= y 80)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance quesDigit3 of QuesDigits
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(4
				(= x (quesDigit4 nsRight:))
				(= y 100)
			)
			(5
				(= x (quesDigit4 nsRight:))
				(= y 80)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance quesDigit2 of QuesDigits
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(2
				(if (== global269 3)
					(= x 105)
				else
					(= x 90)
				)
				(= y 113)
			)
			(4
				(= x (quesDigit3 nsRight:))
				(= y 100)
			)
			(5
				(= x (quesDigit3 nsRight:))
				(= y 80)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance quesDigit1 of QuesDigits
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(1
				(= x 115)
				(= y 113)
			)
			(2
				(= x (quesDigit2 nsRight:))
				(= y 113)
			)
			(4
				(= x (quesDigit2 nsRight:))
				(= y 100)
			)
			(5
				(= x (quesDigit2 nsRight:))
				(= y 80)
			)
			(else
				(= x 0)
			)
		)
		(super init: global117)
	)
)

(instance operator of View
	(properties
		loop 4
	)

	(method (init)
		(self ignoreActors: 1)
		(= view [local4 global269])
		(switch (ManipQues numDigits:)
			(1
				(= x (+ (quesDigit1 nsRight:) 10))
				(= y 113)
			)
			(2
				(= x (+ (quesDigit1 nsRight:) 10))
				(= y 113)
			)
			(4
				(= x (+ (quesDigit1 nsRight:) 10))
				(= y 100)
			)
			(5
				(= x (+ (quesDigit1 nsRight:) 10))
				(= y 80)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance equalSign of View
	(properties
		loop 4
		cel 1
	)

	(method (init)
		(self ignoreActors: 1)
		(= view [local4 global269])
		(switch (ManipQues numDigits:)
			(1
				(= x (+ (quesDigit6 nsRight:) 10))
				(= y 113)
			)
			(2
				(= x (+ (quesDigit6 nsRight:) 10))
				(= y 113)
			)
			(4
				(= x (+ (quesDigit6 nsRight:) 10))
				(= y 150)
			)
			(5
				(= x (+ (quesDigit6 nsRight:) 10))
				(= y 150)
			)
			(else
				(= y (= x 0))
			)
		)
		(super init: global117)
	)
)

(instance quesIndicator1 of QuesDigits
	(properties
		loop 4
		cel 4
	)

	(method (init)
		(self ignoreActors: 1)
		(= view [local4 global269])
		(switch (ManipQues numDigits:)
			(1
				(= x (- (quesDigit1 nsLeft:) 10))
				(= y 113)
			)
			(2
				(= x (- (quesDigit2 nsLeft:) 10))
				(= y 113)
			)
			(5
				(= x (- (quesDigit5 nsLeft:) 10))
				(= y 80)
			)
		)
		(super init: global117)
	)
)

(instance quesIndicator2 of QuesDigits
	(properties
		loop 4
		cel 4
	)

	(method (init)
		(self ignoreActors: 1)
		(= view [local4 global269])
		(switch (ManipQues numDigits:)
			(1
				(= x (- (quesDigit6 nsLeft:) 10))
				(= y 113)
			)
			(2
				(= x (- (quesDigit7 nsLeft:) 10))
				(= y 113)
			)
			(5
				(= x (- (quesDigit10 nsLeft:) 10))
				(= y 150)
			)
		)
		(super init: global117)
	)
)

(class AnsDigit of View
	(properties
		y 227
		loop 3
	)

	(method (init)
		(self ignoreActors: 1)
		(= view [local4 global269])
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
		(self ignoreActors: 1)
		(= view [local4 global269])
		(switch (ManipQues numDigits:)
			(1
				(= x (- (ansDigit1 nsLeft:) 10))
			)
			(2
				(= x (- (ansDigit2 nsLeft:) 10))
			)
			(5
				(= x (- (ansDigit5 nsLeft:) 10))
			)
		)
		(super init: global117)
	)
)

(instance ansDigit1 of AnsDigit
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
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
				(= x 0)
			)
		)
		(if (>= (AnsManager digitCount:) 1)
			(= cel (local157 at: 0))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance ansDigit2 of AnsDigit
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(2
				(= x 147)
			)
			(4
				(= x (ansDigit3 nsRight:))
			)
			(5
				(= x (ansDigit3 nsRight:))
			)
			(else
				(= x 0)
			)
		)
		(if (>= (AnsManager digitCount:) 2)
			(= cel (local157 at: 1))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance ansDigit3 of AnsDigit
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
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
		(if (>= (AnsManager digitCount:) 3)
			(= cel (local157 at: 2))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance ansDigit4 of AnsDigit
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(4
				(= x 121)
			)
			(5
				(= x (ansDigit5 nsRight:))
			)
			(else
				(= x 0)
			)
		)
		(if (>= (AnsManager digitCount:) 4)
			(= cel (local157 at: 3))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance ansDigit5 of AnsDigit
	(properties)

	(method (init)
		(switch (ManipQues numDigits:)
			(5
				(if (== global269 3)
					(= x 130)
				else
					(= x 110)
				)
			)
			(else
				(= x 0)
			)
		)
		(if (>= (AnsManager digitCount:) 5)
			(= cel (local157 at: 4))
		else
			(= cel 16)
		)
		(super init: global117)
	)
)

(instance theReward of View
	(properties
		x 62
		y 32
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
		(= view [local4 global269])
		(super init: global117 &rest)
	)
)

(instance sPromptUser of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local154 0)
				(= cycles 1)
			)
			(1
				(= seconds 12)
			)
			(2
				(if (== (AnsManager digitCount:) (ManipQues numDigits:))
					(self dispose:)
				else
					(if (== local154 (AnsManager digitCount:))
						(questionSnd play:)
					)
					(= local154 (AnsManager digitCount:))
					(-= state 2)
					(= cycles 1)
				)
			)
		)
	)
)

(instance sGiveDemo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
				(= local151 (Random 0 2))
				(= local152 (Random 0 2))
				(= local153 (Random 0 2))
				(gGame handsOff:)
			)
			(1
				(localproc_2 0)
				(= seconds 1)
			)
			(2
				(= local154 (ManipQues numDigits:))
				(= local155 (localproc_0 (ManipQues theAns:) local154))
				((ScriptID 4035 0) init:) ; LearningMachineKeys
				(= cycles 1)
			)
			(3
				((ScriptID 4035 0) showKeyDown: (local155 at: (- local154 1))) ; LearningMachineKeys
				(= seconds 1)
			)
			(4
				((ScriptID 4035 0) showKeyUp:) ; LearningMachineKeys
				(if (-- local154)
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
				(if (ManipQues givingDemo:)
					(sGiveDemo dispose:)
					((ScriptID 4035 0) showKeyUp:) ; LearningMachineKeys
				)
				(ManipQues incNumCorrect:)
				(= global268 (ManipQues numCorrect:))
				(= local156 0)
				(= cycles 1)
			)
			(2
				(ManipQues hideAll:)
				(AnsManager hideAll:)
				(theReward view: [local8 global269] init: global117)
				(correctSnd play: self)
			)
			(3
				(= cycles 80)
			)
			(4
				(theReward dispose:)
				(ansDigit1 init: global117)
				(if (ManipQues givingDemo:)
					((ScriptID 4035 0) setActive: 1) ; LearningMachineKeys
					(ManipQues givingDemo: 0)
				)
				(= cycles 90)
			)
			(5
				(if (< (ManipQues numCorrect:) 5)
					(gGame handsOn:)
					(localproc_2 0)
					(self dispose:)
				else
					(ManipQues numCorrect: 0)
					(= global268 (ManipQues numCorrect:))
					(ManipQues dispose:)
					(AnsManager dispose:)
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
				(ManipQues hideAll:)
				(= temp0 (ManipQues numCorrect:))
				(if (>= local156 3)
					(if temp0
						(ManipQues numCorrect: (-- temp0))
					)
					(= global268 (ManipQues numCorrect:))
					(= local156 0)
				)
				(AnsManager hideAll:)
				(wrongSnd play: self)
				(theReward view: [local12 global269] init: global117)
				(FrameOut)
			)
			(2
				(= cycles 80)
			)
			(3
				(theReward dispose:)
				(gGame handsOn:)
				(localproc_2 0)
				(self dispose:)
			)
		)
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
		cel 5
		view 600
	)
)

(instance backupExit of ExitFeature
	(properties
		nsBottom 289
		nsLeft 89
		nsRight 461
		nsTop 254
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
		nsBottom 276
		nsLeft 21
		nsRight 568
		nsTop 10
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

