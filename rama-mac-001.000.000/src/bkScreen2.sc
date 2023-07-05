;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4010)
(include sci.sh)
(use Main)
(use Location)
(use SaveManager)
(use Feature)
(use Actor)
(use System)

(public
	bkScreen2 0
)

(local
	[local0 4] = [0 4010 4110 4210]
	local4
	[local5 69] = [0 218 264 250 265 282 265 310 265 342 265 217 290 249 291 283 291 311 291 343 291 171 265 203 264 234 264 265 264 296 264 327 264 357 264 389 264 170 289 201 289 234 289 263 289 294 289 327 289 359 289 389 289 168 290 200 291 233 291 266 291 299 291 328 291 360 291 391 291]
	local74
	local75
	local76
)

(procedure (localproc_0 param1)
	(switch local4
		(0
			(cond
				((InRect 215 236 377 263 param1)
					(cond
						((InRect 219 241 241 265 param1)
							(return 0)
						)
						((InRect 251 241 275 265 param1)
							(return 1)
						)
						((InRect 283 241 308 265 param1)
							(return 2)
						)
						((InRect 313 241 339 265 param1)
							(return 3)
						)
						((InRect 346 241 371 265 param1)
							(return 4)
						)
						(else
							(return -1)
						)
					)
				)
				((InRect 215 264 376 290 param1)
					(cond
						((InRect 217 266 240 290 param1)
							(return 5)
						)
						((InRect 249 266 272 290 param1)
							(return 6)
						)
						((InRect 282 266 305 290 param1)
							(return 7)
						)
						((InRect 313 266 337 290 param1)
							(return 8)
						)
						((InRect 345 266 370 290 param1)
							(return 9)
						)
						(else
							(return -1)
						)
					)
				)
				(else
					(return -1)
				)
			)
		)
		(1
			(cond
				((InRect 163 238 432 264 param1)
					(cond
						((InRect 172 241 196 266 param1)
							(return 0)
						)
						((InRect 204 241 227 266 param1)
							(return 1)
						)
						((InRect 235 241 261 266 param1)
							(return 2)
						)
						((InRect 266 241 292 266 param1)
							(return 3)
						)
						((InRect 297 241 324 266 param1)
							(return 4)
						)
						((InRect 329 241 354 266 param1)
							(return 5)
						)
						((InRect 361 241 386 266 param1)
							(return 6)
						)
						((InRect 391 241 417 266 param1)
							(return 7)
						)
						(else
							(return -1)
						)
					)
				)
				((InRect 163 265 432 290 param1)
					(cond
						((InRect 169 266 192 291 param1)
							(return 8)
						)
						((InRect 202 266 226 291 param1)
							(return 9)
						)
						((InRect 235 266 258 291 param1)
							(return 10)
						)
						((InRect 266 266 291 291 param1)
							(return 11)
						)
						((InRect 298 266 324 291 param1)
							(return 12)
						)
						((InRect 329 266 356 291 param1)
							(return 13)
						)
						((InRect 360 266 389 291 param1)
							(return 14)
						)
						((InRect 392 266 419 291 param1)
							(return 15)
						)
						(else
							(return -1)
						)
					)
				)
				(else
					(return -1)
				)
			)
		)
		(2
			(cond
				((InRect 171 240 190 290 param1)
					(return 0)
				)
				((InRect 203 240 223 290 param1)
					(return 1)
				)
				((InRect 234 240 252 290 param1)
					(return 2)
				)
				((InRect 267 240 287 290 param1)
					(return 3)
				)
				((InRect 301 240 320 290 param1)
					(return 4)
				)
				((InRect 332 240 353 290 param1)
					(return 5)
				)
				((InRect 362 240 386 290 param1)
					(return 6)
				)
				((InRect 392 240 416 290 param1)
					(return 7)
				)
				(else
					(return -1)
				)
			)
		)
		(else
			(return -1)
		)
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(= temp5 (/ (= temp3 param1) 10))
	(= temp4 (mod temp3 10))
	(= temp6 33)
	(= temp7 197)
	(if (not (squareList isEmpty:))
		(localproc_2)
	)
	(for ((= temp2 1)) (<= temp2 temp5) ((++ temp2))
		(squareList add: ((square new:) cel: 1 x: temp6 y: temp7 yourself:))
		(+= temp6 21)
	)
	(= temp0 (+ 36 (* temp5 21)))
	(= temp1 42)
	(if (>= temp5 25)
		(-= temp0 21)
		(+= temp1 170)
	)
	(for ((= temp2 1)) (<= temp2 temp4) ((++ temp2))
		(squareList add: ((square new:) cel: 0 x: temp0 y: temp1 yourself:))
		(if (>= temp5 25)
			(-= temp0 21)
		else
			(+= temp1 17)
		)
	)
	(if (not (squareList isEmpty:))
		(squareList eachElementDo: #init global117)
		(FrameOut)
	)
)

(procedure (localproc_2)
	(squareList dispose:)
)

(instance bkScreen2 of CloseupLocation
	(properties)

	(method (init)
		(if (== global269 2)
			(= heading 270)
		else
			(= heading 90)
		)
		(super init: [local0 global269] &rest)
		(= plane global116)
		(Screen2Keys init:)
		(tallyBrd_90 init:)
		(switch gPrevRoomNum
			(4004 ; bk1CountRm
				(= global269 1)
				(TheRequest init: 10)
			)
			(4104 ; bk2Anteroom
				(= global269 2)
				(TheRequest init: 16)
			)
			(4204 ; bk3Anteroom
				(= global269 3)
				(TheRequest init: 8)
			)
		)
	)

	(method (serialize param1 &tmp temp0)
		(if param1
			(super serialize: param1 0)
			(= local75 (SaveManager readWord:))
			(= local76 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local75)
			(SaveManager writeWord: local76)
		)
	)

	(method (pitch param1)
		(if local76
			(gCurRoom setScript: sTurnOffLights)
		else
			(super pitch: param1)
		)
	)

	(method (notify param1)
		(TheRequest checkRequest: param1)
	)
)

(class Screen2Keys of Feature
	(properties
		nsLeft 163
		nsTop 235
		nsRight 432
		nsBottom 290
		currentKey -1
		active 1
		priority 255
	)

	(method (init)
		(= plane global116)
		(super init: &rest)
		(switch global269
			(1
				(= local4 0)
				(= local74 1)
			)
			(2
				(= local4 1)
				(= local74 21)
			)
			(3
				(= local4 2)
				(= local74 53)
			)
		)
		(keyPressed init: global117 hide:)
		(= currentKey -1)
		(gExtMouseHandler addToFront: self)
	)

	(method (dispose)
		(gExtMouseHandler delete: self)
		(keyPressed dispose:)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event localize: global116)
		(cond
			((and (not (event type:)) (self onMe: event))
				(if (!= (localproc_0 event) -1)
					(self doVerb: 1)
				else
					(gTheCursor setTempCursor:)
				)
				(event claimed: 1)
				(return)
			)
			((and active (self onMe: event) (& (event type:) evMOUSEBUTTON))
				(if (!= (= temp1 (localproc_0 event)) -1)
					(= currentKey temp1)
					(gCurRoom notify: currentKey)
					(self doVerb: 2)
				)
				(event claimed: 1)
			)
			(else
				(event globalize:)
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb &tmp [temp0 2])
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (!= currentKey -1)
					(keyPressed show: currentKey)
					(self trace:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (trace &tmp temp0 temp1 temp2)
		(= temp2 1)
		(while (and (!= ((= temp1 (Event new:)) type:) evMOUSERELEASE) temp2)
			(temp1 localize: global116)
			(if (== (localproc_0 temp1) currentKey)
				(= temp2 1)
			else
				(= temp2 0)
			)
			(temp1 dispose:)
		)
		(keyPressed hide:)
		(temp1 dispose:)
	)
)

(instance keyPressed of View
	(properties)

	(method (init)
		(switch global269
			(1
				(= view 4001)
			)
			(2
				(= view 4101)
			)
			(3
				(= view 4201)
			)
		)
		(= cel 16)
		(super init: &rest)
	)

	(method (show param1 &tmp temp0 temp1 temp2)
		(if (!= param1 -1)
			(= temp0 [local5 (= temp2 (+ (* param1 2) local74))])
			(= temp1 [local5 (+ temp2 1)])
			(self cel: param1 posn: temp0 temp1)
			(super show: &rest)
			(FrameOut)
		)
	)
)

(class TheRequest of Obj
	(properties
		curRequest 0
		digitCount 0
		requestBase 0
	)

	(method (init param1)
		(= digitCount local76)
		(= curRequest local75)
		(= requestBase param1)
		(digit1 init: global117)
		(digit2 init: global117)
		(if (>= digitCount 2)
			(localproc_1 curRequest)
		)
		(super init:)
	)

	(method (checkRequest param1)
		(switch (++ digitCount)
			(2
				(= curRequest (+ (* curRequest requestBase) param1))
				(digit2 cel: (digit1 cel:))
				(digit1 cel: param1)
				(localproc_1 curRequest)
			)
			(else
				(= curRequest 0)
				(digit2 cel: 16)
				(digit1 cel: param1)
				(= curRequest param1)
				(if (> digitCount 2)
					(localproc_2)
					(= digitCount 1)
				)
			)
		)
		(= local76 digitCount)
		(= local75 curRequest)
		(UpdateScreenItem digit1)
		(UpdateScreenItem digit2)
		(FrameOut)
	)

	(method (dispose)
		(digit1 dispose:)
		(digit2 dispose:)
		(super dispose:)
	)
)

(class Digit of View
	(properties
		loop 2
	)

	(method (init)
		(switch global269
			(1
				(= view 4001)
			)
			(2
				(= view 4101)
			)
			(3
				(= view 4201)
			)
		)
		(super init: &rest)
	)
)

(instance digit1 of Digit
	(properties)

	(method (init)
		(switch global269
			(1
				(= x 309)
				(= y 229)
			)
			(2
				(= x 306)
				(= y 226)
			)
			(3
				(= x 301)
				(= y 233)
			)
		)
		(if (>= (TheRequest digitCount:) 1)
			(= cel (mod (TheRequest curRequest:) (TheRequest requestBase:)))
		else
			(= cel 16)
		)
		(super init: &rest)
	)
)

(instance digit2 of Digit
	(properties)

	(method (init)
		(switch global269
			(1
				(= x 273)
				(= y 229)
			)
			(2
				(= x 271)
				(= y 226)
			)
			(3
				(= x 266)
				(= y 233)
			)
		)
		(if (>= (TheRequest digitCount:) 2)
			(= cel (/ (TheRequest curRequest:) (TheRequest requestBase:)))
		else
			(= cel 16)
		)
		(super init: &rest)
	)
)

(instance square of View
	(properties
		loop 1
	)

	(method (init)
		(switch global269
			(1
				(= view 4001)
			)
			(2
				(= view 4101)
			)
			(3
				(= view 4201)
			)
		)
		(super init: global117)
	)
)

(instance squareList of List
	(properties)
)

(instance tallyBrd_90 of Feature
	(properties
		nsLeft 26
		nsTop 25
		nsRight 562
		nsBottom 222
		x 294
		y 123
	)

	(method (init)
		(super init: &rest)
		(switch global269
			(1
				(= noun 5)
			)
			(2
				(= noun 24)
			)
			(3
				(= noun 42)
			)
		)
		(self setHotspot: 144)
	)
)

(instance sTurnOffLights of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (squareList isEmpty:))
					(localproc_2)
				)
				(= local76 0)
				(TheRequest dispose:)
				(= seconds 2)
			)
			(1
				(gGame handsOn:)
				(gCurRoom pitch:)
				(self dispose:)
			)
		)
	)
)

