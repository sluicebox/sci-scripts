;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use ExitButton)
(use HotSpot)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use Osc)
(use Timer)
(use Sound)
(use Actor)
(use System)

(public
	PactTimer 0
)

(local
	local0
)

(class Clock of View
	(properties
		startTimer 0
		timeHolder 0
		placeHolder 0
		parTime 0
		currentTime 0
		caller 0
		butt1 0
		butt2 0
		butt3 0
		butt4 0
		shotsAllowed 0
		curShot 0
		curOverShot 0
		overCntr 0
		firstOver 0
		foundOver 0
		onLight 0
		shotTimes 0
		restartTimer 0
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 19922)
		((= butt1 button1)
			view: view
			loop: 3
			cel: 0
			x: x
			y: (- y 1)
			setPri: (+ priority 1)
			init:
		)
		((= butt2 button2)
			view: view
			loop: 4
			cel: 0
			x: x
			y: (- y 1)
			setPri: (+ priority 1)
			init:
		)
		((= butt3 button3)
			view: view
			loop: 5
			cel: 0
			x: x
			y: (- y 1)
			setPri: (+ priority 1)
			init:
		)
		((= butt4 button4)
			view: view
			loop: 6
			cel: 0
			x: x
			y: (- y 1)
			setPri: (+ priority 1)
			init:
		)
		(if (not shotTimes)
			(= shotTimes (IntArray new: 100))
		)
		(SetNowSeen self)
		(SetNowSeen butt1)
		(pactHotSpot init:)
	)

	(method (start param1)
		(self toggleLight: 1)
		(= startTimer 1)
		(if argc
			(= caller param1)
		)
	)

	(method (stop)
		(self toggleLight: 0)
		(= startTimer 0)
	)

	(method (dispose)
		(= startTimer 0)
		(drillTimer dispose: delete:)
		(pactHotSpot dispose:)
		(shotTimes dispose:)
		(= shotTimes 0)
		(butt1 dispose:)
		(butt2 dispose:)
		(butt3 dispose:)
		(butt4 dispose:)
		(self toggleLight: 0 clearClock: 1)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if startTimer
			(if (not placeHolder)
				(= placeHolder (GetTime))
			)
			(= timeHolder (- (GetTime) placeHolder))
			(= currentTime (/ timeHolder 6))
			(if (== currentTime parTime)
				(pactSound loop: 1 play:)
			)
			(if (or (>= currentTime (* parTime 2)) (< currentTime 0))
				(= currentTime (* parTime 2))
				(self stop: cueCaller:)
			)
			(if (timerPrint dialog:)
				((timerPrint dialog:) dispose:)
			)
			(= temp0 (/ currentTime 10))
			(= temp1
				(Str
					format: {TOTAL: %02d.%d} temp0 (- currentTime (* temp0 10))
				)
			)
			(timerPrint addTextF: (temp1 data:) init:)
			(temp1 dispose:)
		)
	)

	(method (setPar param1 &tmp temp0 temp1)
		(self clearClock: 0)
		(timerPrint addText: {TOTAL: 00.0} init:)
		(if param1
			(= temp0 (/ (= parTime param1) 10))
			(switch (gGame printLang:)
				(33
					(= temp1
						(Str
							format:
								{TEMPS: %02d.%d}
								temp0
								(- param1 (* temp0 10))
						)
					)
				)
				(else
					(= temp1
						(Str
							format: {PAR: %02d.%d} temp0 (- param1 (* temp0 10))
						)
					)
				)
			)
			(parPrint addText: (temp1 data:) init:)
			(temp1 dispose:)
		)
	)

	(method (toggleLight param1)
		(if (and (not param1) onLight)
			(onLight dispose:)
			(= onLight 0)
		)
		(if (and param1 (not onLight))
			((= onLight (View new:))
				view: view
				loop: 7
				cel: 0
				x: (+ x 66)
				y: (- y 41)
				setPri: (+ priority 2)
				init:
			)
		)
	)

	(method (cueCaller)
		(if caller
			(if (caller respondsTo: #cue)
				(if (not gCuees)
					(= gCuees (Set new:))
				)
				(gCuees add: ((Cue new:) cuee: caller yourself:))
			else
				(caller doit:)
			)
		)
	)

	(method (cycleThruShots &tmp temp0 temp1 temp2 temp3)
		(if (not curShot)
			(= curShot global135)
		)
		(self clearClock: 0)
		(if (== (= temp0 (+ (- global135 curShot) 1)) 1)
			(= temp1 (shotTimes at: (- global135 curShot)))
		else
			(= temp1
				(-
					(shotTimes at: (- global135 curShot))
					(shotTimes at: (- (- global135 curShot) 1))
				)
			)
		)
		(if (<= temp1 0)
			(-- curShot)
		else
			(= temp2 (/ temp1 10))
			(switch (gGame printLang:)
				(33
					(= temp3
						(Str
							format:
								{#%01d    ECART: %02d.%d}
								temp0
								temp2
								(- temp1 (* temp2 10))
						)
					)
				)
				(else
					(= temp3
						(Str
							format:
								{#%01d    SPLIT TIME: %02d.%d}
								temp0
								temp2
								(- temp1 (* temp2 10))
						)
					)
				)
			)
			(shotPrint addText: (temp3 data:) init:)
			(temp3 dispose:)
		)
		(-- curShot)
	)

	(method (clearClock param1 &tmp temp0)
		(if (shotPrint dialog:)
			((shotPrint dialog:) dispose:)
		)
		(if (overPrint dialog:)
			((overPrint dialog:) dispose:)
		)
		(if (timerPrint dialog:)
			((timerPrint dialog:) dispose:)
		)
		(if (parPrint dialog:)
			((parPrint dialog:) dispose:)
		)
		(if (or (not argc) param1)
			(self toggleLight: 0)
			(= curShot
				(= onLight
					(= shotsAllowed
						(= currentTime
							(= parTime
								(= placeHolder
									(= timeHolder
										(= curOverShot
											(= startTimer
												(= foundOver
													(= firstOver (= overCntr 0))
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(if shotTimes
				(for ((= temp0 0)) (< temp0 100) ((++ temp0))
					(shotTimes at: temp0 0)
				)
			)
		)
	)

	(method (showFirst &tmp temp0 temp1)
		(self clearClock: 0)
		(= temp0 (/ (shotTimes at: 0) 10))
		(switch (gGame printLang:)
			(33
				(= temp1
					(Str
						format:
							{1ER COUP:   %02d.%d}
							temp0
							(- (shotTimes at: 0) (* temp0 10))
					)
				)
			)
			(else
				(= temp1
					(Str
						format:
							{FIRST SHOT:   %02d.%d}
							temp0
							(- (shotTimes at: 0) (* temp0 10))
					)
				)
			)
		)
		(shotPrint addText: (temp1 data:) init:)
		(temp1 dispose:)
	)

	(method (showOver &tmp temp0 temp1 temp2 temp3 temp4)
		(self clearClock: 0)
		(if (not foundOver)
			(for ((= temp2 0)) (< temp2 global135) ((++ temp2))
				(if (> (shotTimes at: temp2) parTime)
					(if (not foundOver)
						(= foundOver 1)
						(= firstOver temp2)
					)
					(++ overCntr)
				)
			)
			(if (not foundOver)
				(switch (gGame printLang:)
					(33
						(shotPrint addText: {DANS LES TEMPS} init:)
					)
					(else
						(shotPrint addText: {NONE OVER} init:)
					)
				)
				(return)
			)
		)
		(overPrint addTextF: { %d} overCntr init:)
		(if (== curOverShot overCntr)
			(= temp0 (= curOverShot 0))
		)
		(= temp0 (+ firstOver curOverShot 1))
		(= temp3
			(/
				(= temp1 (- (shotTimes at: (+ firstOver curOverShot)) parTime))
				10
			)
		)
		(switch (gGame printLang:)
			(33
				(= temp4
					(Str
						format:
							{#%01d D\90PASSEMENT: %02d.%d}
							temp0
							temp3
							(- temp1 (* temp3 10))
					)
				)
			)
			(else
				(= temp4
					(Str
						format:
							{#%01d     OVER: %02d.%d}
							temp0
							temp3
							(- temp1 (* temp3 10))
					)
				)
			)
		)
		(shotPrint addText: (temp4 data:) init:)
		(temp4 dispose:)
		(++ curOverShot)
	)

	(method (startDrillTimer param1 param2 &tmp temp0)
		(= temp0 (if (not argc) 5 else param1))
		(if (> argc 1)
			(= caller param2)
		)
		(drillTimer setReal: drillTimer param1)
	)

	(method (stopDrillTimer)
		(if (gTimers contains: drillTimer)
			(drillTimer dispose:)
		)
	)

	(method (pause param1)
		(cond
			((and argc param1)
				(= restartTimer startTimer)
				(= startTimer 0)
			)
			(restartTimer
				(= startTimer 1)
				(= placeHolder (GetTime))
				(-= placeHolder timeHolder)
			)
		)
	)
)

(class clockPrint of Print
	(properties
		fore 2
	)

	(method (doit)
		(return 0)
	)

	(method (init)
		(= back (= skip -1))
		(= modeless 2)
		(super init: &rest)
	)

	(method (dispose)
		(if dialog
			(dialog dispose:)
		)
		(super dispose:)
	)

	(method (showSelf &tmp [temp0 2] temp2 temp3 [temp4 2])
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		((= plane
				(if plane
					(plane new:)
				else
					(gSystemPlane new:)
				)
			)
			back: 0
			picture: -2
			priority: (+ ((ScriptID 50 0) priority:) 1) ; PactTimer
		)
		(dialog
			plane: plane
			name: {PODialog}
			caller: self
			text: title
			ticks: ticks
			margin: margin
			modeless: modeless
			onScreen: onScreen
			setSize:
		)
		(dialog init: (plane priority:))
		(dialog center:)
		(= temp2
			(if (== x -1)
				(dialog nsLeft:)
			else
				x
			)
		)
		(= temp3
			(if (== y -1)
				(dialog nsTop:)
			else
				y
			)
		)
		(dialog moveTo: temp2 temp3 eachElementDo: #updatePlane)
		(FrameOut)
		(gPrints addToFront: self)
	)

	(method (handleEvent))
)

(instance timerPrint of clockPrint
	(properties)

	(method (init)
		(= x (- ((ScriptID 50 0) x:) 27)) ; PactTimer
		(= y (- ((ScriptID 50 0) y:) 31)) ; PactTimer
		(super init: &rest)
	)
)

(instance parPrint of clockPrint
	(properties)

	(method (init)
		(= x (- ((ScriptID 50 0) x:) (proc4_16 73 80 73 73 73))) ; PactTimer
		(= y (- ((ScriptID 50 0) y:) 31)) ; PactTimer
		(super init: &rest)
	)
)

(instance shotPrint of clockPrint
	(properties)

	(method (init)
		(= x (- ((ScriptID 50 0) x:) 81)) ; PactTimer
		(= y (- ((ScriptID 50 0) y:) 44)) ; PactTimer
		(super init: &rest)
	)
)

(instance overPrint of clockPrint
	(properties)

	(method (init)
		(= x (- ((ScriptID 50 0) x:) 81)) ; PactTimer
		(= y (- ((ScriptID 50 0) y:) 31)) ; PactTimer
		(super init: &rest)
	)
)

(class PactButton of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (isActive)
		(gTimers contains: drillTimer)
	)

	(method (doAction)
		(return 0)
	)

	(method (handleEvent event)
		(if (and (self isActive:) (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(if (gCurRoom inset:)
				(return)
			else
				(self setCycle: Osc 1)
				(self doAction:)
			)
		)
		(super handleEvent: event)
	)
)

(instance button1 of PactButton
	(properties)

	(method (doAction)
		((ScriptID 50 0) cycleThruShots:) ; PactTimer
	)
)

(instance button2 of PactButton
	(properties)

	(method (doAction)
		((ScriptID 50 0) showFirst:) ; PactTimer
	)
)

(instance button3 of PactButton
	(properties)

	(method (doAction)
		((ScriptID 50 0) showOver:) ; PactTimer
	)
)

(instance button4 of PactButton
	(properties)

	(method (doAction)
		((ScriptID 50 0) stopDrillTimer: cueCaller:) ; PactTimer
	)
)

(instance drillTimer of Timer
	(properties)

	(method (doit)
		(cond
			(
				(and
					(not (PactTimer onMe: (gUser curEvent:)))
					(not (button1 onMe: (gUser curEvent:)))
					(not (button2 onMe: (gUser curEvent:)))
					(not (button3 onMe: (gUser curEvent:)))
					(not (button4 onMe: (gUser curEvent:)))
				)
				(super doit: &rest)
			)
			((< seconds 3)
				(= seconds 3)
			)
		)
	)

	(method (cue)
		((ScriptID 50 0) cueCaller:) ; PactTimer
	)
)

(instance PactTimer of Clock
	(properties)
)

(instance pactHotSpot of HotSpot
	(properties
		type 8
	)

	(method (init)
		(= nsLeft (PactTimer nsLeft:))
		(= nsTop (- ((PactTimer butt1:) nsTop:) 5))
		(= nsRight (PactTimer nsRight:))
		(= nsBottom (PactTimer nsBottom:))
		(super init: &rest)
	)

	(method (setupCursor)
		(gTheHotspotCursor view: 999 loop: 0 cel: 0)
	)

	(method (doVerb))
)

(instance pactSound of Sound
	(properties
		number 19922
	)
)

