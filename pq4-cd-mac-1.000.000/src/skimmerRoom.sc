;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use DText)
(use Str)
(use Print)
(use Scaler)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	skimmerRoom 0
)

(local
	local0
	local1
	local2
	local3 = 4
	local4 = 265
	local5 = 75
	local6 = 15
	local7
	local8
	local9
	local10
	local11
	local12
)

(instance skimmerRoom of Room
	(properties
		picture 80
	)

	(method (init &tmp temp0)
		(gTheIconBar disable:)
		(Platform 0 2 1)
		(gThePlane setRect: 0 0 319 189 1)
		(super init: &rest)
		(gGlobalSound0 number: 1031 setLoop: -1 setVol: 127 play:)
		(sFx init:)
		(if (not global167)
			((ScriptID 2011) init:) ; doScore
		)
		(skimmer init: setCycle: Fwd)
		(= local7 (Cast new:))
		(gThePlane addCast: local7)
		(local7 add:)
		((life new:) ignoreActors: init:)
		((life new:) ignoreActors: init:)
		(meter ignoreActors: init:)
		(gasGauge ignoreActors: init: setScript: useGas)
		(skimmer setScript: sEnter)
		(gTheCursor hide:)
		(= temp0 (Str new: 10))
		(temp0 format: {%d} local8)
		(= local9
			((DText new:)
				text: (KString 8 (temp0 data:)) ; StrDup
				font: 230
				mode: 1
				fore: 0
				back: 10
				skip: 10
				setSize:
				fixPriority: 1
				priority: 300
				moveTo: 20 10
				init:
			)
		)
		(temp0 dispose:)
		(= local11 1)
		(gMouseDownHandler addToFront: self)
		((gTheIconBar plane:) priority: -1)
		(FrameOut)
		(if (< gHowFast 7)
			(PalCycle 0 38 111 -2 1) ; Start
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event claimed: 1)
		(if (and (& (event type:) evMOUSEBUTTON) (not (local7 isEmpty:)))
			(= temp1 (gGame setCursor: gTheArrowCursor 1))
			(gTheCursor show:)
			(while 1
				(switch
					(Print
						addBitmap: 64994 1 0
						width: 80
						addText: 0 0 3 1 5 2 41 ; "Are you sure you want to quit?"
						addButtonBM: 64994 0 0 0 0 0 3 3 12 33 41 ; "No"
						addButtonBM: 64994 0 0 1 0 0 3 2 12 57 41 ; "Yes"
						init:
					)
					(0
						(= temp0 0)
						(break)
					)
					(1
						(= temp0 1)
						(break)
					)
				)
			)
			(gGame setCursor: temp1 0)
			(if temp0
				(gCurRoom newRoom: 910)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound0 fade: 0 2 2 1)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(local7 dispose:)
		((gTheIconBar plane:) priority: 1)
		(gThePlane setRect: 0 0 319 153 1)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance life of Actor
	(properties)

	(method (init)
		(self
			view: 80
			loop: 5
			cel: 0
			x: local6
			y: 187
			fixPriority: 1
			priority: 300
		)
		(+= local6 20)
		(super init:)
		(gCast delete: self)
		(local7 addToFront: self)
	)

	(method (dispose)
		(local7 delete: self)
		(super dispose:)
	)
)

(instance meter of Actor
	(properties
		x 300
		y 20
		priority 300
		fixPriority 1
		view 80
		loop 6
	)
)

(instance gasGauge of Actor
	(properties
		x 300
		y 187
		priority 300
		fixPriority 1
		view 80
		loop 7
	)
)

(instance skimmer of Actor
	(properties
		x 160
		y 280
		view 80
		cycleSpeed 8
		xStep 14
		moveSpeed 0
	)

	(method (init)
		(self setLoop: 0 1)
		(super init:)
	)

	(method (doit &tmp temp0)
		(if (or script local12)
			(super doit:)
		else
			(if (!= 160 gMouseX)
				(cond
					((> gMouseX 165)
						(if (< x local4)
							(= loop 1)
							(+= x xStep)
							(sFx setVol: 127)
						)
					)
					((and (> x local5) (< gMouseX 155))
						(= loop 2)
						(-= x xStep)
						(sFx setVol: 127)
					)
				)
				(gTheCursor posn: 160 100)
			else
				(sFx setVol: 100)
				(= loop 0)
			)
			(super doit:)
		)
	)

	(method (cue)
		(= loop 0)
	)
)

(instance mountain of Actor
	(properties)

	(method (new param1 &tmp temp0)
		(= temp0 (super new:))
		(temp0
			view: 82
			setLoop: param1
			y: 100
			moveSpeed: 1
			origStep: 2591
			cel: local1
			setScaler: Scaler 100 30 130 100
		)
		(if (== local1 2)
			(= local1 0)
		else
			(++ local1)
		)
		(if param1
			(temp0 x: 40 init: setMotion: MoveTo -50 130 temp0)
		else
			(temp0 x: 280 init: setMotion: MoveTo 370 130 temp0)
		)
		(temp0 signal: (| (temp0 signal:) $4000))
	)

	(method (motionCue)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance stuff of Actor
	(properties)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(if (not (Random 0 20))
			(temp0
				view: 83
				y: 90
				x: (Random 110 210)
				setLoop: (Random 0 1) 1
				moveSpeed: 0
				cycleSpeed: 0
				origStep:
					(cond
						((> gHowFast 6) 7967)
						((> gHowFast 4) 6168)
						(else 4883)
					)
				priority: 0
				setScaler: Scaler 100 10 220 95
				init:
			)
			(temp0 setMotion: MoveTo (+ 10 (* (- (temp0 x:) 110) 3)) 220 temp0)
			(temp0 signal: (| (temp0 signal:) $4000))
		else
			(temp0
				view: 81
				y: 90
				x: (Random 100 200)
				setLoop: (Random 0 3) 1
				moveSpeed: 0
				cycleSpeed: 0
				origStep:
					(cond
						((> gHowFast 6) 7967)
						((> gHowFast 4) 6168)
						(else 4883)
					)
				priority: 0
				setScaler: Scaler 100 10 220 95
				init:
			)
			(temp0 setMotion: MoveTo (+ 10 (* (- (temp0 x:) 110) 3)) 220 temp0)
			(temp0 signal: (| (temp0 signal:) $4000))
		)
	)

	(method (motionCue)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if
			(and
				(not (skimmer script:))
				(<= 150 y 180)
				(ObjectIntersect self skimmer)
			)
			(SetNowSeen self)
			(SetNowSeen skimmer)
			(= temp1 (Min (skimmer nsRight:) nsRight))
			(= temp4 (Min (skimmer nsBottom:) nsBottom))
			(= temp2 (Max (skimmer nsLeft:) nsLeft))
			(= temp5 (Max (skimmer nsTop:) nsTop))
			(= temp3 (>> (+ temp4 temp5) $0001))
			(= temp6 0)
			(for ((= temp0 temp2)) (<= temp0 temp1) ((++ temp0))
				(if (and (OnMe temp0 temp3 self 1) (OnMe temp0 temp3 skimmer 1))
					(= temp6 1)
					(break)
				)
			)
			(if (not temp6)
				(= temp0 (>> (+ temp1 temp2) $0001))
				(for ((= temp3 temp5)) (<= temp3 temp4) ((++ temp3))
					(if
						(and
							(OnMe temp0 temp3 self 1)
							(OnMe temp0 temp3 skimmer 1)
						)
						(= temp6 1)
						(break)
					)
				)
			)
			(cond
				((not temp6)
					(super doit:)
				)
				((== view 83)
					(if loop
						(if local2
							(-- local2)
						)
						(stuffSfx number: 1048 setLoop: 1 play:)
						(meter cel: local2)
						(UpdateScreenItem meter)
						(self dispose:)
					else
						(if (useGas seconds:)
							(useGas seconds: 30)
						)
						(stuffSfx number: 1041 setLoop: 1 play:)
						(if (gasGauge cel:)
							(gasGauge cel: (- (gasGauge cel:) 1))
							(UpdateScreenItem gasGauge)
						)
						(self dispose:)
					)
				)
				(else
					(self setCycle: End)
					(switch loop
						(0
							(stuffSfx number: 1042 setLoop: 1 play:)
						)
						(1
							(stuffSfx number: 1047 setLoop: 1 play:)
						)
						(2
							(stuffSfx number: 1049 setLoop: 1 play:)
						)
						(3
							(stuffSfx number: 1050 setLoop: 1 play:)
						)
					)
					(+= local2 loop)
					(meter cel: (Min local3 local2))
					(if (> local2 local3)
						(skimmer setScript: crash)
					else
						(skimmer setScript: hit)
					)
					(UpdateScreenItem meter)
					(super doit:)
				)
			)
		else
			(super doit:)
		)
	)

	(method (dispose &tmp temp0 temp1 temp2)
		(if (and (== y 220) (!= view 83))
			(= temp1 local8)
			(= temp2 (+= local8 (* 5 loop)))
			(if temp1
				(while (> temp1 0)
					(-= temp1 2000)
					(-= temp2 2000)
				)
				(if (and (< (local7 size:) 12) (> temp2 0))
					((life new:) ignoreActors: init:)
				)
			)
			(if (gCast contains: local9)
				(local9 dispose:)
				(= local9 0)
			)
			(= temp0 (Str new: 10))
			(temp0 format: {%d} local8)
			(= local9
				((DText new:)
					text: (KString 8 (temp0 data:)) ; StrDup
					font: 230
					mode: 1
					fore: 0
					back: 10
					skip: 10
					setSize:
					fixPriority: 1
					priority: 300
					moveTo: 20 10
					init:
				)
			)
			(temp0 dispose:)
		)
		(super dispose:)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance useGas of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(if (< (gasGauge cel:) (gasGauge lastCel:))
					(gasGauge cel: (+ (gasGauge cel:) 1))
					(UpdateScreenItem gasGauge)
					(= state -1)
					(= cycles 2)
				else
					(sFx number: 1044 setLoop: 1 play: self)
					(PalCycle 4) ; Off
					(= local12 1)
					(skimmer loop: 0 setCycle: 0)
					(gCast eachElementDo: #perform stopMoving)
					(gCurRoom setScript: 0)
				)
			)
			(2
				(gMessager say: 0 0 4 0 self) ; "Maybe you should pay closer attention to your fuel gauge!"
			)
			(3
				(if (local7 isEmpty:)
					(gCurRoom setScript: credits)
					(self dispose:)
				else
					(gGame fade: 100 0 10)
					((local7 at: 0) dispose:)
					(gCast eachElementDo: #dispose)
					(FrameOut)
					(meter ignoreActors: cel: 0 init:)
					(gasGauge ignoreActors: cel: 0 init: setScript: useGas)
					(= local2 0)
					(= temp0 (Str new: 10))
					(temp0 format: {%d} local8)
					(= local9
						((DText new:)
							text: (KString 8 (temp0 data:)) ; StrDup
							font: 230
							mode: 1
							fore: 0
							back: 10
							skip: 10
							setSize:
							fixPriority: 1
							priority: 300
							moveTo: 20 10
							init:
						)
					)
					(temp0 dispose:)
					(if (< (-= local6 20) 15)
						(= local6 15)
					)
					(if (< gHowFast 7)
						(PalCycle 0 38 111 -2 1) ; Start
					)
					(= local12 0)
					(FrameOut)
					(gGame fade: 0 100 10)
					(skimmer
						loop: 0
						x: 160
						y: 280
						init:
						setCycle: Fwd
						setScript: sEnter
					)
					(= state -1)
					(= cycles 2)
				)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
				(if local11
					(= state 1)
				)
			)
			(1
				(gMessager say: 0 0 2 0 self) ; "Sand Warrior Instructions:"
			)
			(2
				(sFx number: 912 setLoop: 1 play: self)
			)
			(3
				(sFx number: 1046 setLoop: -1 play: setVol: 100)
				(skimmer setMotion: MoveTo 160 180 self)
			)
			(4
				(gCurRoom setScript: throwStuff)
				(self dispose:)
			)
		)
	)
)

(instance hit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(skimmer setLoop: 3 setMotion: 0 cel: 0 setCycle: End self)
			)
			(1
				(skimmer setCycle: Beg self)
			)
			(2
				(skimmer loop: 0 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance stopMoving of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #mover)
			(param1 setMotion: 0)
		)
	)
)

(instance crash of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(PalCycle 4) ; Off
				(sFx number: 1045 setLoop: 1 play:)
				(gCast eachElementDo: #perform stopMoving)
				(gCurRoom setScript: 0)
				(skimmer
					setLoop: 3
					setMotion: 0
					cycleSpeed: 8
					cel: 0
					setCycle: End self
				)
			)
			(1
				(skimmer loop: 4 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 0 0 1 0 self) ; "You need to take a remedial driving course!"
			)
			(3
				(if (local7 isEmpty:)
					(gCurRoom setScript: credits)
					(self dispose:)
				else
					(gGame fade: 100 0 10)
					((local7 at: 0) dispose:)
					(gCast eachElementDo: #dispose)
					(FrameOut)
					(meter ignoreActors: cel: 0 init:)
					(gasGauge ignoreActors: cel: 0 init: setScript: useGas)
					(= local2 0)
					(= temp0 (Str new: 10))
					(temp0 format: {%d} local8)
					(= local9
						((DText new:)
							text: (KString 8 (temp0 data:)) ; StrDup
							font: 230
							mode: 1
							fore: 0
							back: 10
							skip: 10
							setSize:
							fixPriority: 1
							priority: 300
							moveTo: 20 10
							init:
						)
					)
					(temp0 dispose:)
					(if (< (-= local6 20) 15)
						(= local6 15)
					)
					(if (< gHowFast 7)
						(PalCycle 0 38 111 -2 1) ; Start
					)
					(FrameOut)
					(gGame fade: 0 100 10)
					(skimmer
						loop: 0
						x: 160
						y: 280
						init:
						setCycle: Fwd
						setScript: sEnter
					)
				)
			)
		)
	)
)

(instance credits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2011) doit: local8) ; doScore
				(self cue:)
			)
			(1
				(= gNewRoomNum 910)
			)
		)
	)
)

(instance throwStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stuff new:)
				(= state -1)
				(cond
					((> local8 30000)
						(= cycles (Random 1 3))
					)
					((> local8 25000)
						(= cycles (Random 1 4))
					)
					((> local8 20000)
						(= cycles (Random 2 4))
					)
					((> local8 15000)
						(= cycles (Random 2 5))
					)
					((> local8 10000)
						(= cycles (Random 3 5))
					)
					((> local8 5000)
						(= cycles (Random 3 6))
					)
					(else
						(= cycles (Random 4 6))
					)
				)
			)
		)
	)
)

(instance doMountains of Script ; UNUSED
	(properties)

	(method (init param1)
		(if argc
			(self setScript: throwStuff)
			(super init: param1 &rest)
		else
			(super init:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(= register 0)
					(if (< gHowFast 4)
						(mountain new: 1)
					)
				else
					(if (< gHowFast 4)
						(mountain new: 0)
					)
					(= register 1)
				)
				(= state -1)
				(= cycles 7)
			)
		)
	)
)

(instance stuffSfx of Sound
	(properties)
)

(instance sFx of Sound
	(properties)
)

