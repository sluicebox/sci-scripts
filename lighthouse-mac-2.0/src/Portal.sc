;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use WalkieTalkie)
(use Timer)
(use Sound)

(public
	Portal 0
	tGateTimer 1
)

(class Portal of WalkieTalkie
	(properties
		number 0
		soundNumber 32511
	)

	(method (kill)
		(ClearFlag 289)
		(ClearFlag 413)
		(ClearFlag 290)
		(ClearFlag 172)
		(self stopSound:)
		(tGateTimer dispose: delete:)
		(self dispose:)
	)

	(method (startSound)
		(if (not (gSounds contains: sndPortal))
			(Lock rsAUDIO soundNumber 1)
			(sndPortal number: soundNumber play:)
		)
	)

	(method (fadeSound)
		(if (gSounds contains: sndPortal)
			(self stopSound:)
		)
	)

	(method (stopSound)
		(sndPortal stop:)
		(gSounds delete: sndPortal)
	)

	(method (startTimer)
		(if (not (gTimers contains: tGateTimer))
			(tGateTimer setReal: tGateTimer (if (IsFlag 290) 60 else 240))
		)
	)

	(method (stopTimer)
		(if (gTimers contains: tGateTimer)
			(tGateTimer dispose: delete:)
		)
	)

	(method (init param1 param2 param3 param4)
		(= x param2)
		(= y param3)
		(= number param1)
		(if (> argc 3)
			(= soundNumber param4)
		)
		(WalkieTalkie doRobot: number x y self 0 500 yourself:)
		(if (not (gTimers contains: tGateTimer))
			(tGateTimer setReal: tGateTimer (if (IsFlag 290) 60 else 240))
		)
		(super init: &rest)
		(= gPortal self)
		(self startSound:)
	)

	(method (soundVol param1)
		(sndPortal setVol: param1)
	)

	(method (cue)
		(WalkieTalkie doRobot: number x y self 0 500 yourself:)
	)

	(method (dispose)
		(if gPortal
			(DoRobot)
		)
		(= gPortal 0)
		(super dispose: &rest)
	)
)

(instance tGateTimer of Timer
	(properties)

	(method (init)
		(SetFlag 172)
		(super init: &rest)
	)

	(method (cue)
		(if (IsFlag 289)
			(if (IsFlag 159)
				(SetFlag 160)
			)
			(ClearFlag 159)
			(ClearFlag 153)
			(ClearFlag 155)
			(ClearFlag 43)
		)
		(if (IsFlag 413)
			(SetFlag 412)
			(ClearFlag 401)
			(ClearFlag 213)
			(= global250 0)
			(= global252 0)
			(= global253 0)
		)
		(if (IsFlag 290)
			(gBackMusic2 stop:)
		)
		(if (and (IsFlag 413) (<= gCurRoomNum 360) (> gCurRoomNum 270))
			(gBackMusic2 stop:)
		)
		(ClearFlag 172)
		(Portal stopSound:)
		(cond
			(
				(and
					(IsFlag 289)
					(or (<= gCurRoomNum 270) (> gCurRoomNum 360))
					(gTimers contains: (ScriptID 19 0)) ; BombTimer
				)
				(gGame handsOff:)
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					((ScriptID 9 2) dispose:) ; PlBagPlane
				)
				(SetFlag 398)
				(SetFlag 400)
				((ScriptID 19 0) seconds: 0) ; BombTimer
			)
			(
				(and
					(IsFlag 289)
					(not (gInventory contains: (ScriptID 9 39))) ; invModulator
					(> gCurRoomNum 270)
					(<= gCurRoomNum 360)
					(== global207 0)
				)
				(gGame handsOff:)
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					((ScriptID 9 2) dispose:) ; PlBagPlane
				)
				(SetFlag 397)
				(if (gTimers contains: (ScriptID 19 0)) ; BombTimer
					((ScriptID 19 0) seconds: 0) ; BombTimer
				else
					(gPanels eachElementDo: #dispose)
					(gCurRoom newRoom: 380)
				)
			)
			(
				(and
					(IsFlag 413)
					(> gCurRoomNum 270)
					(<= gCurRoomNum 360)
					(gTimers contains: (ScriptID 19 0)) ; BombTimer
				)
				(gGame handsOff:)
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					((ScriptID 9 2) dispose:) ; PlBagPlane
				)
				((ScriptID 19 0) seconds: 0) ; BombTimer
			)
			(
				(and
					(IsFlag 413)
					(or (<= gCurRoomNum 270) (> gCurRoomNum 360))
					(gTimers contains: (ScriptID 19 0)) ; BombTimer
					(not (gInventory contains: (ScriptID 9 39))) ; invModulator
				)
				(gGame handsOff:)
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					((ScriptID 9 2) dispose:) ; PlBagPlane
				)
				(SetFlag 398)
				(SetFlag 400)
				((ScriptID 19 0) seconds: 0) ; BombTimer
			)
			(
				(and
					(IsFlag 413)
					(> gCurRoomNum 270)
					(<= gCurRoomNum 360)
					(not (gInventory contains: (ScriptID 9 39))) ; invModulator
					(== global207 0)
					(not (IsFlag 155))
				)
				(gGame handsOff:)
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					((ScriptID 9 2) dispose:) ; PlBagPlane
				)
				(SetFlag 397)
				(if (gTimers contains: (ScriptID 19 0)) ; BombTimer
					((ScriptID 19 0) seconds: 0) ; BombTimer
				else
					(gPanels eachElementDo: #dispose)
					(gCurRoom newRoom: 380)
				)
			)
			((== gCurRoomNum 800)
				(gCurRoom notify:)
			)
			((and (IsFlag 289) (<= (gCurRoom scene:) 289))
				(gCurRoom notify: 1)
			)
			((and (IsFlag 289) (== (gCurRoom scene:) 364))
				((ScriptID 1 1) dispose:) ; exitForward
			)
			((and (IsFlag 289) (== (gCurRoom scene:) 370))
				(gCurRoom notify:)
			)
			((and (IsFlag 290) (== (gCurRoom scene:) 341))
				((ScriptID 1 1) dispose:) ; exitForward
			)
		)
		(ClearFlag 289)
		(ClearFlag 413)
		(ClearFlag 290)
		(Portal dispose:)
		(tGateTimer dispose: delete:)
	)
)

(instance sndPortal of Sound
	(properties
		flags 1
		loop -1
	)

	(method (init)
		(Lock rsAUDIO number 1)
		(super init: &rest)
	)

	(method (dispose)
		(Lock rsAUDIO number 0)
		(super dispose: &rest)
	)
)

