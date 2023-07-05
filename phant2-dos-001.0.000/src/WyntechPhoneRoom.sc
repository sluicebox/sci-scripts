;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63018)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use Str)
(use PolyEdit)

(local
	local0 = 261
	local1 = 91
)

(class WyntechPhoneRoom of CloseupRoom
	(properties
		picture 235
		curNum 0
	)

	(method (init &tmp temp0)
		(for ((= temp0 4030)) (<= temp0 4042) ((++ temp0))
			(Load 140 temp0) ; WAVE
			(Lock 140 temp0 1) ; WAVE
		)
		(super init: &rest)
		(= curNum (Str new: 0))
		(zeroButton new:)
		(oneButton new:)
		(twoButton new:)
		(threeButton new:)
		(fourButton new:)
		(fiveButton new:)
		(sixButton new:)
		(sevenButton new:)
		(eightButton new:)
		(nineButton new:)
		(starButton new:)
		(poundButton new:)
		(hookButton new:)
		(self hook:)
	)

	(method (dial param1)
		(gP2SoundFX stop:)
		(gP2SoundFX loop: 0)
		(gP2SoundFX play: (Random 4031 4037))
		(curNum
			cat:
				(switch param1
					(0 {0})
					(1 {1})
					(2 {2})
					(3 {3})
					(4 {4})
					(5 {5})
					(6 {6})
					(7 {7})
					(8 {8})
					(9 {9})
					(10 {*})
					(11 {#})
				)
		)
		(cond
			((>= (curNum size:) 4)
				(gP2SoundFX waitEvent:)
				(gTheCursor set: 999 ((ScriptID 0 4) lookup: gVerb) 0) ; cursorLoopTable
				(FrameOut)
				(self call: (curNum asInteger:))
			)
			((and (== (curNum size:) 1) (== param1 0))
				(gP2SoundFX waitEvent:)
				(self busy:)
			)
		)
	)

	(method (call)
		(proc63002_11 4000 15 0 64 1)
		(self hook:)
	)

	(method (hook)
		(gP2SoundFX stop:)
		(gP2SoundFX loop: -1)
		(gP2SoundFX play: 4038)
		(curNum dispose:)
		(= curNum (Str new: 0))
	)

	(method (ring)
		(gP2SoundFX stop:)
		(gP2SoundFX loop: 0)
		(gP2SoundFX play: 4039)
		(gP2SoundFX waitEvent:)
		(self hook:)
	)

	(method (busy)
		(gP2SoundFX stop:)
		(gP2SoundFX loop: 0)
		(gP2SoundFX play: 4040)
		(gP2SoundFX waitEvent:)
		(self hook:)
	)

	(method (dispose &tmp temp0)
		(if curNum
			(curNum dispose:)
		)
		(gP2SoundFX stop:)
		(gP2SoundFX loop: 0)
		(for ((= temp0 4030)) (<= temp0 4042) ((++ temp0))
			(Lock 140 temp0 0) ; WAVE
			(UnLoad 140 temp0)
		)
		(super dispose: &rest)
	)
)

(class PhoneButton of P2Feature
	(properties
		myView 0
		myNum -1
	)

	(method (new)
		((super new:) init:)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			((= myView (View new:))
				view: 235
				loop: 0
				cel: myNum
				init: gThePlane
				posn: local0 local1
			)
			((gUser hogs:) push: self 0)
			(event claimed: 1)
		else
			(if (and myView (& (event type:) evMOUSERELEASE))
				((gUser hogs:) pop:)
				(myView dispose:)
				(= myView 0)
				(gCurRoom dial: myNum)
			)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

(instance zeroButton of PhoneButton
	(properties
		myNum 0
	)

	(method (init)
		(super init: (proc63002_10 335 239 360 252 349 271 323 259))
	)
)

(instance oneButton of PhoneButton
	(properties
		myNum 1
	)

	(method (init)
		(super init: (proc63002_10 354 109 386 125 370 141 344 127))
	)
)

(instance twoButton of PhoneButton
	(properties
		myNum 2
	)

	(method (init)
		(super init: (proc63002_10 400 128 427 143 412 163 386 149))
	)
)

(instance threeButton of PhoneButton
	(properties
		myNum 3
	)

	(method (init)
		(super init: (proc63002_10 441 149 466 164 453 182 427 171))
	)
)

(instance fourButton of PhoneButton
	(properties
		myNum 4
	)

	(method (init)
		(super init: (proc63002_10 334 145 362 157 349 176 322 164))
	)
)

(instance fiveButton of PhoneButton
	(properties
		myNum 5
	)

	(method (init)
		(super init: (proc63002_10 378 167 406 178 392 197 365 184))
	)
)

(instance sixButton of PhoneButton
	(properties
		myNum 6
	)

	(method (init)
		(super init: (proc63002_10 419 186 445 199 434 218 408 206))
	)
)

(instance sevenButton of PhoneButton
	(properties
		myNum 7
	)

	(method (init)
		(super init: (proc63002_10 313 180 341 192 328 214 303 199))
	)
)

(instance eightButton of PhoneButton
	(properties
		myNum 8
	)

	(method (init)
		(super init: (proc63002_10 353 199 385 216 370 236 345 222))
	)
)

(instance nineButton of PhoneButton
	(properties
		myNum 9
	)

	(method (init)
		(super init: (proc63002_10 398 222 424 237 414 256 387 242))
	)
)

(instance starButton of PhoneButton
	(properties
		myNum 10
	)

	(method (init)
		(super init: (proc63002_10 280 233 292 215 319 226 307 247))
	)
)

(instance poundButton of PhoneButton
	(properties
		myNum 11
	)

	(method (init)
		(super init: (proc63002_10 365 276 377 256 401 270 390 287))
	)
)

(instance hookButton of PhoneButton
	(properties)

	(method (init)
		(super init: (proc63002_10 428 98 440 76 498 104 488 124))
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			((= myView (View new:))
				view: 235
				loop: 1
				cel: 1
				init: gThePlane
				posn: 427 104
			)
			((gUser hogs:) push: self 0)
			(event claimed: 1)
		else
			(if (and myView (& (event type:) evMOUSERELEASE))
				((gUser hogs:) pop:)
				(myView dispose:)
				(= myView 0)
				(gCurRoom hook:)
			)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

