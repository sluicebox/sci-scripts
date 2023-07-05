;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use ExitButton)
(use Str)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm30 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp2 (param1 cel:))
	(param1 cel: (+ temp2 param2))
	(UpdateScreenItem param1)
	(FrameOut)
	(= temp3 1)
	(while (!= ((= temp1 (Event new:)) type:) evMOUSERELEASE)
		(temp1 localize: gThePlane)
		(cond
			((param1 onMe: temp1)
				(if (== (param1 cel:) temp2)
					(param1 cel: (+ (param1 cel:) param2))
					(= temp3 1)
					(UpdateScreenItem param1)
					(FrameOut)
				)
			)
			((!= (param1 cel:) temp2)
				(param1 cel: temp2)
				(= temp3 0)
				(UpdateScreenItem param1)
				(FrameOut)
			)
		)
		(temp1 dispose:)
		(= temp1 0)
	)
	(if temp1
		(temp1 dispose:)
	)
	(param1 cel: temp2)
	(UpdateScreenItem param1)
	(return temp3)
)

(procedure (localproc_1 param1 &tmp temp0) ; UNUSED
	(Str format: {%s%s} gCurSaveDir param1)
)

(instance rm30 of Room
	(properties
		picture 10007
	)

	(method (init)
		(= local0 global124)
		(= global124 (Cast new:))
		(gUser useHotspots: 1)
		(Load rsVIEW 10007)
		(Load rsVIEW 930)
		(gThePlane setRect: 0 0 319 199 priority: 4)
		(gMouseDownHandler add: gCurRoom)
		(gKeyDownHandler add: gCurRoom)
		(gDirectionHandler add: gCurRoom)
		(super init:)
		(RemapColors 2 244 60) ; ByPercent
		(self setScript: doTheOpening)
	)

	(method (dispose)
		(global124 dispose:)
		(= global124 local0)
		(gGame handsOff:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gGame isHandsOn: 1 handsOff:)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (< (doTheOpening state:) 5)
			(doTheOpening changeState: 5)
			(gKqMusic1 stop:)
		)
		(event claimed: 1)
	)
)

(instance doTheOpening of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 1)
				(if (== gPrevRoomNum 15)
					(kqLogo init:)
					(subtitle init: z: 1000)
					(Load 140 1199) ; WAVE
				)
			)
			(1
				(if (== gPrevRoomNum 15)
					(gKqMusic1 number: 1199 setLoop: 1 play:)
					(= ticks 90)
				else
					(gKqMusic1 stop:)
					(self changeState: 7)
				)
			)
			(2
				(= ticks 90)
			)
			(3
				(subtitle z: 0 setCycle: End)
				(= ticks 90)
			)
			(4
				(= ticks 100)
			)
			(5
				(subtitle
					setLoop: 1
					setCel: 0
					x: 89
					y: 146
					setCycle: End subtitle
				)
				(= ticks 90)
			)
			(6
				(kqLogo z: 1000 dispose:)
				(subtitle z: 1000 dispose:)
				(= cycles 1)
			)
			(7
				(gMouseDownHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
				(if global308
					(= global308 0)
					(gGame isHandsOn: 0 oldCurs: gNormalCursor)
				)
				(gGame handsOn:)
				(Platform 0 2 1)
				(watchBut y: 20 init: setHotspot: 8 10) ; Do, Exit
				(startBut y: 47 init: setHotspot: 8 10) ; Do, Exit
				(contBut y: 74 init: setHotspot: 8 10) ; Do, Exit
				(aboutBut y: 103 init: setHotspot: 8 10) ; Do, Exit
				(quitBut y: 132 init: setHotspot: 8 10) ; Do, Exit
				(self dispose:)
			)
		)
	)
)

(instance kqLogo of Prop
	(properties
		x 1
		y 131
		view 10006
	)
)

(instance subtitle of Prop
	(properties
		x 89
		y 146
		view 10007
	)

	(method (cue)
		(self dispose:)
	)
)

(instance watchBut of View
	(properties
		x 120
		view 930
		loop 1
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(gKqMusic1 fade:)
			(gCurRoom newRoom: 34)
		)
	)
)

(instance startBut of View
	(properties
		x 105
		view 930
		loop 2
	)

	(method (doVerb &tmp temp0 temp1 [temp2 3])
		(if (localproc_0 self 1)
			((ScriptID 16 1) hide:) ; scroller
			(for ((= temp1 0)) (< temp1 (gInventory size:)) ((++ temp1))
				((gInventory at: temp1) owner: -1 hide:)
			)
			(global108 release:)
			(global124 release:)
			(= gInventoryCount 0)
			(gCurRoom newRoom: 20) ; nameGameRoom
			(if (> (gGame speedRating:) 165)
				(SetFlag 97)
			else
				(ClearFlag 97)
				(ClearFlag 538)
			)
			(return 1)
		)
	)
)

(instance contBut of View
	(properties
		x 95
		view 930
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(ClearFlag 3)
			(gCurRoom newRoom: 23) ; selectGameRoom
			(return 1)
		)
	)
)

(instance aboutBut of View
	(properties
		x 130
		view 930
		loop 3
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(WinHelp 1 {kq7game.hlp} 1)
			(return 1)
		)
	)
)

(instance quitBut of View
	(properties
		x 134
		view 930
		loop 4
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(= gQuit 1)
			(return 1)
		)
	)
)

