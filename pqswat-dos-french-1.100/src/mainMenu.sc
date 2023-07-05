;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use PQRoom)
(use Button)
(use Str)
(use Actor)
(use System)

(public
	mainMenu 0
)

(instance mainMenu of PQRoom
	(properties
		picture 12
	)

	(method (init)
		(Lock rsAUDIO 1500 1)
		(while (== 15 (= picture (+ 12 global119)))
			(if (> (++ global119) 5)
				(= global119 0)
			)
		)
		(SetFlag 3)
		(super init: &rest)
		(gGame handsOff:)
		(gSwatInterface hideCursor: 0)
		(self setScript: delayMenu)
	)

	(method (dispose)
		(Lock rsAUDIO 1500 0)
		(gBackMusic fade: 0 2 21 1)
		(ClearFlag 3)
		(super dispose: &rest)
	)
)

(instance delayMenu of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(if (and (== state 1) (gBackMusic handle:) (== (event message:) KEY_SPACE))
				(event claimed: 1)
				(= cycles (= seconds 0))
				(self cue:)
			else
				(super handleEvent: event)
			)
			(event claimed:)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gBackMusic number: 1500 flags: 1 setLoop: -1 play:)
				(if register
					(self cue:)
				else
					(= seconds 4)
				)
			)
			(2
				(gKeyDownHandler delete: self)
				(menuView init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance menuView of View
	(properties
		priority 1
		fixPriority 1
		view 150
	)

	(method (init &tmp temp0 temp1 temp2)
		(super init: &rest)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (plane right:) (plane left:)) temp0) 2))
		(= y (- (/ (- (- (plane bottom:) (plane top:)) temp1) 2) 20))
		(newCareer init:)
		(prevCareer init:)
		(cntrlPanel init:)
		(credits init:)
		(quitButn init:)
	)

	(method (dispose)
		(newCareer dispose:)
		(prevCareer dispose:)
		(cntrlPanel dispose:)
		(credits dispose:)
		(quitButn dispose:)
		(super dispose:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance newCareer of Button
	(properties
		view 150
		loop 1
	)

	(method (init)
		(= x (+ (menuView x:) 77))
		(= y (+ (menuView y:) 76))
		(super init: &rest)
	)

	(method (doVerb)
		(gGame getDisc: 1)
		(gCurRoom newRoom: 20) ; newCareer
	)
)

(instance prevCareer of Button
	(properties
		view 150
		loop 2
	)

	(method (init)
		(= x (+ (menuView x:) 76))
		(= y (+ (menuView y:) 119))
		(super init: &rest)
	)

	(method (doVerb &tmp temp0)
		(= temp0 (Str format: {%s%s} (gStr data:) {swatid.cat}))
		(if (FileIO fiEXISTS (temp0 data:))
			(temp0 dispose:)
			(gCurRoom newRoom: 25) ; prevCareerId
		else
			(temp0 dispose:)
			(gMessager say: 10 0 22 0 0 0) ; "You have no previous careers at this time."
		)
	)
)

(instance cntrlPanel of Button
	(properties
		view 150
		loop 3
	)

	(method (init)
		(= x (+ (menuView x:) 76))
		(= y (+ (menuView y:) 164))
		(super init: &rest)
	)

	(method (doVerb)
		(delayMenu register: 1)
		(gGame controlPanel:)
		(gCurRoom setScript: delayMenu)
	)
)

(instance credits of Button
	(properties
		view 150
		loop 4
	)

	(method (init)
		(= x (+ (menuView x:) 77))
		(= y (+ (menuView y:) 207))
		(super init: &rest)
	)

	(method (doVerb)
		(delayMenu register: 1)
		((ScriptID 40 0) init:) ; creditScreen
		(gCurRoom setScript: delayMenu)
	)
)

(instance quitButn of Button
	(properties
		view 150
		loop 5
	)

	(method (init)
		(= x (+ (menuView x:) 77))
		(= y (+ (menuView y:) 250))
		(super init: &rest)
	)

	(method (doVerb)
		(= gQuit 2)
	)
)

