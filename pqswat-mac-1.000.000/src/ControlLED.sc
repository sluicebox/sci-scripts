;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Button)
(use Plane)
(use Str)
(use Array)
(use Cursor)
(use Actor)
(use System)

(public
	proc11_0 0
)

(local
	local0
	local1
)

(procedure (proc11_0 &tmp temp0 temp1 temp2 temp3)
	(if global112
		((ScriptID 71 0) pausePath: 1) ; crisisRegion
	)
	(if gAutoRobot
		(Robot 10) ; Pause
	)
	(if (gCast contains: (ScriptID 50 0)) ; PactTimer
		((ScriptID 50 0) pause: 1) ; PactTimer
	)
	(= local1 (= temp1 (= temp2 (= temp0 (= local0 0)))))
	(= temp1 gCast)
	((= temp2 (Plane new:))
		setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
		back: 0
		picture: -2
		priority: 500
		init:
		addCast: (= gCast (Cast new:))
	)
	(controlView init:)
	(questionMark init:)
	(aboutButn init:)
	(saveMission init: setActive: 1)
	(restoreMission init: setActive: 1)
	(playButn init:)
	(quitButn init:)
	(volumeUpButn init:)
	(volumeDownButn init:)
	(callUpsUpButn init:)
	(callUpsDownButn init:)
	(volumeLed init: gGame 539)
	(callUpsLed init: gGame 896)
	(FrameOut)
	(UpdatePlane temp2)
	(= temp0 (gGame setCursor:))
	(gNormalCursor view: 999 loop: 0)
	(gGame setCursor: gNormalCursor 1)
	(for
		((= temp3 ((gUser curEvent:) new:)))
		(temp3 type:)
		((= temp3 ((gUser curEvent:) new:)))
	)
	(while (not local0)
		(while (or (not (temp3 type:)) (not (& (temp3 type:) $0001)))
			(= temp3 ((gUser curEvent:) new:))
		)
		(gCast eachElementDo: #handleEvent temp3)
		(= temp3 ((gUser curEvent:) new:))
	)
	(if (gTalkers size:)
		(gTalkers eachElementDo: #dispose 1)
	)
	(gCast dispose:)
	(= gCast temp1)
	(gGame setCursor: temp0 1)
	(temp2 dispose:)
	(if (and (not (OneOf local1 1 2)) gAutoRobot)
		(Robot 4) ; Play
	)
	(if global112
		((ScriptID 71 0) pausePath: 0) ; crisisRegion
	)
	(if (gCast contains: (ScriptID 50 0)) ; PactTimer
		((ScriptID 50 0) pause:) ; PactTimer
	)
	(return local1)
)

(instance controlView of View
	(properties
		priority 151
		fixPriority 1
		view 16
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance questionMark of Button
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 1
	)

	(method (init)
		(= x (+ (controlView x:) 118))
		(= y (+ (controlView y:) 194))
		(super init: &rest)
	)

	(method (doVerb)
		(swatHelp doit:)
	)
)

(instance aboutButn of Button
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 2
	)

	(method (init)
		(= x (+ (controlView x:) 32))
		(= y (+ (controlView y:) 194))
		(super init: &rest)
	)

	(method (doVerb)
		(= local0 1)
		((ScriptID 40 0) init:) ; creditScreen
	)
)

(instance saveMission of Button
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 3
	)

	(method (init)
		(= x (+ (controlView x:) 16))
		(= y (+ (controlView y:) 70))
		(super init: &rest)
	)

	(method (doVerb)
		(if (== global111 -1)
			(gMessager say: 9 2 4 0 0 0) ; "You have no game play to save at this time."
		else
			(= local1 1)
			(= local0 1)
		)
	)
)

(instance restoreMission of Button
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 4
	)

	(method (init)
		(= x (+ (controlView x:) 16))
		(= y (+ (controlView y:) 110))
		(super init: &rest)
	)

	(method (doVerb &tmp temp0 temp1)
		(= temp0 (Str new: 20))
		(= temp1 (IntArray new: 20))
		(if (not (Save 5 (gGame name:) (temp0 data:) (temp1 data:))) ; GetSaveFiles
			(gMessager say: 9 2 13 0 0 0) ; "This career has no saved games in which to restore."
		else
			(= local1 2)
			(= local0 1)
		)
		(temp0 dispose:)
		(temp1 dispose:)
	)
)

(instance playButn of Button
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 5
	)

	(method (init)
		(= x (+ (controlView x:) 16))
		(= y (+ (controlView y:) 151))
		(super init: &rest)
	)

	(method (doVerb)
		(= local0 1)
	)
)

(instance quitButn of Button
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 6
	)

	(method (init)
		(= x (+ (controlView x:) 104))
		(= y (+ (controlView y:) 151))
		(super init: &rest)
	)

	(method (doVerb)
		(= local0 1)
		(= gQuit 2)
	)
)

(instance volumeUpButn of Button
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 8
	)

	(method (init)
		(= x (+ (controlView x:) 230))
		(= y (+ (controlView y:) 101))
		(super init: &rest)
		(&= signal $efff)
	)

	(method (doVerb)
		(volumeLed adjustValue: 13)
	)
)

(instance callUpsUpButn of Button
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 8
	)

	(method (init)
		(= x (+ (controlView x:) 294))
		(= y (+ (controlView y:) 101))
		(super init: &rest)
		(&= signal $efff)
	)

	(method (doVerb)
		(callUpsLed adjustValue: -1)
	)
)

(instance volumeDownButn of Button
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 9
	)

	(method (init)
		(= x (+ (controlView x:) 230))
		(= y (+ (controlView y:) 221))
		(super init: &rest)
		(&= signal $efff)
	)

	(method (doVerb)
		(volumeLed adjustValue: -13)
	)
)

(instance callUpsDownButn of Button
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 9
	)

	(method (init)
		(= x (+ (controlView x:) 294))
		(= y (+ (controlView y:) 221))
		(super init: &rest)
		(&= signal $efff)
	)

	(method (doVerb)
		(callUpsLed adjustValue: 1)
	)
)

(class ControlLED of View
	(properties
		priority 180
		fixPriority 1
		view 16
		loop 7
		monObj 0
		monSel 0
		value 0
		minValue 0
		maxValue 10
		increment 1
	)

	(method (init param1 param2)
		(= monObj param1)
		(= monSel param2)
		(super init: &rest)
		(= increment (/ 30 maxValue))
		(self evalObj: displayValue:)
	)

	(method (evalObj param1)
		(if argc
			(= param1 (Max minValue (Min maxValue param1)))
			(Eval monObj monSel param1)
		)
		(Eval monObj monSel)
	)

	(method (adjustValue param1 &tmp temp0)
		(= temp0 (self evalObj:))
		(self evalObj: (+ temp0 param1))
		(self displayValue:)
	)

	(method (displayValue)
		(= cel (* (self evalObj:) increment))
		(UpdateScreenItem self)
		(FrameOut)
	)
)

(instance volumeLed of ControlLED
	(properties
		maxValue 127
	)

	(method (init)
		(= x (+ (controlView x:) 224))
		(= y (+ (controlView y:) 125))
		(super init: &rest)
	)

	(method (displayValue &tmp temp0)
		(= cel (/ (= temp0 (gGame masterVolume:)) 4))
		(UpdateScreenItem self)
		(FrameOut)
	)
)

(instance callUpsLed of ControlLED
	(properties
		maxValue 15
	)

	(method (init)
		(= x (+ (controlView x:) 290))
		(= y (+ (controlView y:) 125))
		(super init: &rest)
	)

	(method (displayValue)
		(= cel (* (Abs (- (self evalObj:) 15)) increment))
		(UpdateScreenItem self)
		(FrameOut)
	)
)

(instance helpCursor of Cursor
	(properties
		view 3
	)
)

(instance swatHelp of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (gGame setCursor: helpCursor 1))
		(= temp2 0)
		(while (!= ((= temp1 (Event new:)) type:) evMOUSEBUTTON)
			(cond
				((and (aboutButn onMe: temp1) (!= temp2 aboutButn))
					(= temp2 aboutButn)
					(if (!= (gNarrator audCase:) 15)
						(if (gTalkers size:)
							(gTalkers eachElementDo: #dispose 1)
						)
						(gMessager say: 9 2 15 1 0 0) ; "Click here to learn more about the creators of Police Quest: SWAT."
					)
				)
				((and (playButn onMe: temp1) (!= temp2 playButn))
					(= temp2 playButn)
					(if (!= (gNarrator audCase:) 16)
						(if (gTalkers size:)
							(gTalkers eachElementDo: #dispose 1)
						)
						(gMessager say: 9 2 16 1 0 0) ; "Click here to resume game play."
					)
				)
				((and (questionMark onMe: temp1) (!= temp2 questionMark))
					(= temp2 questionMark)
					(if (!= (gNarrator audCase:) 14)
						(if (gTalkers size:)
							(gTalkers eachElementDo: #dispose 1)
						)
						(gMessager say: 9 2 14 1 0 0) ; "To learn about the other items in this window first click here. Then pass the question mark cursor over the other items contained within this window."
					)
				)
				((and (quitButn onMe: temp1) (!= temp2 quitButn))
					(= temp2 quitButn)
					(if (!= (gNarrator audCase:) 17)
						(if (gTalkers size:)
							(gTalkers eachElementDo: #dispose 1)
						)
						(gMessager say: 9 2 17 1 0 0) ; "Click here to leave the game."
					)
				)
				((and (restoreMission onMe: temp1) (!= temp2 restoreMission))
					(= temp2 restoreMission)
					(if (!= (gNarrator audCase:) 18)
						(if (gTalkers size:)
							(gTalkers eachElementDo: #dispose 1)
						)
						(gMessager say: 9 2 18 1 0 0) ; "Click here to restore a game saved earlier."
					)
				)
				((and (saveMission onMe: temp1) (!= temp2 saveMission))
					(= temp2 saveMission)
					(if (!= (gNarrator audCase:) 19)
						(if (gTalkers size:)
							(gTalkers eachElementDo: #dispose 1)
						)
						(gMessager say: 9 2 19 1 0 0) ; "Click here to save the current state of your game. When you later select the Restore button everything will be exactly as it is now."
					)
				)
				((and (volumeUpButn onMe: temp1) (!= temp2 volumeUpButn))
					(= temp2 volumeUpButn)
					(if (!= (gNarrator audCase:) 21)
						(if (gTalkers size:)
							(gTalkers eachElementDo: #dispose 1)
						)
						(gMessager say: 9 2 21 1 0 0) ; "To increase intensity click on the top arrow button with the plus sign."
					)
				)
				((and (callUpsUpButn onMe: temp1) (!= temp2 callUpsUpButn))
					(= temp2 callUpsUpButn)
					(if (!= (gNarrator audCase:) 21)
						(if (gTalkers size:)
							(gTalkers eachElementDo: #dispose 1)
						)
						(gMessager say: 9 2 21 1 0 0) ; "To increase intensity click on the top arrow button with the plus sign."
					)
				)
				((and (volumeDownButn onMe: temp1) (!= temp2 volumeDownButn))
					(= temp2 volumeDownButn)
					(if (!= (gNarrator audCase:) 20)
						(if (gTalkers size:)
							(gTalkers eachElementDo: #dispose 1)
						)
						(gMessager say: 9 2 20 1 0 0) ; "To decrease instensity click on the bottom arrow button with the minus sign."
					)
				)
				((and (callUpsDownButn onMe: temp1) (!= temp2 callUpsDownButn))
					(= temp2 callUpsDownButn)
					(if (!= (gNarrator audCase:) 20)
						(if (gTalkers size:)
							(gTalkers eachElementDo: #dispose 1)
						)
						(gMessager say: 9 2 20 1 0 0) ; "To decrease instensity click on the bottom arrow button with the minus sign."
					)
				)
				(else
					(= temp2 0)
				)
			)
			(gTalkers eachElementDo: #doit firstTrue: #handleEvent temp1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(temp1 dispose:)
		)
		(gGame setCursor: temp0 1)
		(if (gTalkers size:)
			(gTalkers eachElementDo: #dispose 1)
		)
	)
)

