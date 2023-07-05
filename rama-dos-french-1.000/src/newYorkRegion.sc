;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SaveManager)
(use n1111)
(use VMDMovie)
(use Print)
(use Timer)
(use Sound)
(use Game)
(use System)

(public
	newYorkRegion 0
	proc201_1 1
	proc201_2 2
	proc201_3 3
	NukeTimer 4
	proc201_5 5
	proc201_6 6
)

(local
	[local0 39] = [2 5 5 5 5 5 10 3 3 5 5 5 5 5 5 5 5 5 5 5 5 5 15 5 5 15 5 10 5 5 3 3 10 10 10 10 10 10 10]
	[local39 39] = [7 1 1 1 2 1 2 6 4 1 1 1 1 1 1 1 1 2 1 2 2 1 1 1 1 1 1 1 1 1 16 9 1 0 0 0 0 0 0]
	[local78 3] = [0 47 853]
	[local81 4] = [383 421 461 503]
	local85
)

(procedure (proc201_1 param1)
	(if argc
		(NukeTimer dec: [local0 param1])
		(newYorkRegion decMinTime: param1 checkTime:)
	else
		(PrintDebug {StupidMove requires an enumerated value, check NEWYORK.SC})
	)
)

(procedure (proc201_2 param1)
	(if (and argc param1)
		(NukeTimer subscribe: param1)
	)
	(NukeTimer pause: 0)
)

(procedure (proc201_3 param1)
	(if (and gTimers (gTimers contains: NukeTimer) (IsFlag 157))
		(NukeTimer client: 0 delete: dispose:)
		(if (gSounds contains: alarmSnd)
			(alarmSnd stop:)
		)
	else
		(NukeTimer unsubscribe: (and argc param1 param1))
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (= temp1 (= temp2 0)))
	(= [local78 0] [local81 (- global179 19)])
	(switch (= temp0 (Random 0 2))
		(0
			(switch (= temp1 (Random 1 2))
				(1
					(= temp2 2)
				)
				(2
					(= temp2 1)
				)
			)
		)
		(1
			(while (== (= temp1 (Random 0 2)) 1)
			)
			(switch temp1
				(0
					(= temp2 2)
				)
				(2
					(= temp2 0)
				)
			)
		)
		(2
			(switch (= temp1 (Random 0 1))
				(0
					(= temp2 1)
				)
				(1
					(= temp2 0)
				)
			)
		)
	)
	(= global180 [local78 temp0])
	(= global181 [local78 temp1])
	(= global182 [local78 temp2])
	(= global184 (mod global180 100))
	(= global185 (* (/ global181 100) 100))
)

(procedure (proc201_5 &tmp temp0)
	(= temp0 0)
	(if (and gTimers (gTimers contains: NukeTimer))
		(= temp0 1)
	)
	(return temp0)
)

(procedure (proc201_6)
	(if (and gTimers (gTimers contains: NukeTimer))
		(NukeTimer seconds: 15)
	)
)

(class NukeTimer of Timer
	(properties
		pause 1
		clients 0
	)

	(method (dec param1)
		(*= param1 60)
		(cond
			((not argc)
				(PrintDebug {Improper StupidMove call - must pass arg})
			)
			((== seconds -1) 0)
			((and (not (self isCountDown:)) (< param1 seconds))
				(-= seconds param1)
				(if clients
					(clients eachElementDo: #updateBombCtr seconds)
				)
			)
		)
	)

	(method (moveDec)
		(if (and (not (self isCountDown:)) (!= seconds -1) (> seconds 10))
			(-= seconds 10)
			(if clients
				(clients eachElementDo: #updateBombCtr seconds)
			)
		)
	)

	(method (isCountDown)
		(return (< 0 seconds 60))
	)

	(method (subscribe param1)
		(if (or (not argc) (not param1))
			(return 0)
		)
		(if (not clients)
			(= clients (List new:))
		)
		(return
			(and (not (clients contains: param1)) (clients addToEnd: param1))
		)
	)

	(method (unsubscribe param1)
		(if clients
			(if (and argc param1 (clients contains: param1))
				(clients delete: param1)
				(if (not (clients size:))
					(= pause 1)
					(clients dispose:)
					(= clients 0)
				)
			else
				(clients release: dispose:)
				(= clients 0)
				(= pause 1)
			)
		)
	)

	(method (serialize param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (= temp2 (= temp1 0)))
		(if (and argc param1)
			(SaveManager restoreTimer:)
			(= pause (SaveManager readWord:))
			(if (= temp1 (SaveManager readWord:))
				(for ((= temp3 0)) (< temp3 temp1) ((++ temp3))
					(= temp0 (SaveManager readWord:))
					(if (not (= temp2 (self getSubscriberObj:)))
						(PrintDebug
							{Restoring NukeTimer client with no ID, see NEWYORK.SC}
						)
					else
						(self subscribe: temp2)
					)
				)
				(if (clients contains: global123)
					(global123 displayBombCtr:)
				)
			)
			(self setReal: self seconds)
		else
			(SaveManager saveTimer: self 201 4)
			(SaveManager writeWord: pause)
			(if clients
				(SaveManager writeWord: (clients size:))
				(for ((= temp3 0)) (< temp3 (clients size:)) ((++ temp3))
					(if
						(not
							(= temp0
								(self getSubscriberID: (clients at: temp3))
							)
						)
						(PrintDebug
							{Saving NukeTimer client with no ID, see NEWYORK.SC}
						)
					)
					(SaveManager writeWord: temp0)
				)
			else
				(SaveManager writeWord: 0)
			)
		)
	)

	(method (getSubscriberID param1)
		(return
			(switch param1
				(global123 1)
				((ScriptID 8115 1) 2) ; theBomb
				((ScriptID 44 7) 3) ; theTimer
				(else 0)
			)
		)
	)

	(method (getSubscriberObj param1)
		(return
			(switch param1
				(1 global123)
				(2
					(ScriptID 8115 1) ; theBomb
				)
				(3
					(ScriptID 44 7) ; theTimer
				)
				(else 0)
			)
		)
	)

	(procedure (localproc_0 &tmp temp0)
		(= temp0 client)
		(= client 0)
		(if temp0
			(if (temp0 respondsTo: #timer)
				(temp0 timer: 0)
			)
			(if (temp0 respondsTo: #cue)
				(temp0 cue:)
			)
		)
	)

	(method (doit &tmp temp0)
		(if
			(and
				(self isCountDown:)
				(or (not clients) (not (clients contains: global123)))
			)
			(proc201_2 global123)
			(global123 displayBombCtr:)
		)
		(cond
			((and pause (not (self isCountDown:))) 0)
			((!= seconds -1)
				(if (!= lastTime (= temp0 (GetTime 1))) ; SysTime12
					(= lastTime temp0)
					(cond
						((not (-- seconds))
							(if clients
								(clients eachElementDo: #updateBombCtr seconds)
							)
							(localproc_0)
						)
						(clients
							(clients eachElementDo: #updateBombCtr seconds)
						)
					)
					(if (and (<= seconds 15) (not local85))
						(= local85 1)
						(newYorkRegion notify: 3)
					)
				)
			)
			(else
				(PrintDebug {nukeTimer abuse!})
			)
		)
	)

	(method (cue)
		(newYorkRegion notify: 2)
		(self client: 0 delete: dispose:)
	)

	(method (setCycle)
		(Prints {don't use this!})
	)

	(method (setTicks)
		(Prints {don't use this!})
	)

	(method (dispose)
		(if (and clients (clients contains: global123))
			(global123 killBombCtr:)
		)
		(self unsubscribe:)
		(= pause 1)
		(super dispose: &rest)
	)
)

(class NewYorkRegion of RamaRegion
	(properties
		mazeSettings 0
		curAPRampPosition 3
		curAPRampDir 1
		moveCnt -1
		dbgMoveCnt -1
		subPuzCU -1
		subPuzCol1 -1
		subPuzCol2 -1
		subPuzCol3 -1
		whichSubPuz 0
		minTimeReq -1
		lastSaveTime -1
	)

	(method (init &tmp temp0)
		(if initialized
			(cond
				(
					(and
						(OneOf gCurRoomNum 5507 5508) ; NYMazeH, NYMazeI
						(OneOf gPrevRoomNum 5507 5508) ; NYMazeH, NYMazeI
					)
					(if (not (gateSnd handle:))
						(gateSnd number: 5501 setVol: 127 owner: self play:)
					)
				)
				(
					(and
						(OneOf gCurRoomNum 5512 5513) ; NYMazeM, NYMazeN
						(OneOf gPrevRoomNum 5512 5513) ; NYMazeM, NYMazeN
						(not (gateSnd handle:))
					)
					(gateSnd number: 5502 setVol: 127 owner: self play:)
				)
				(
					(and
						(OneOf gCurRoomNum 5517 5519) ; NYMazeR, NYMazeT
						(OneOf gPrevRoomNum 5517 5519) ; NYMazeR, NYMazeT
						(not (gateSnd handle:))
					)
					(gateSnd number: 5503 setVol: 127 owner: self play:)
				)
			)
			(NukeTimer moveDec:)
			(if (!= dbgMoveCnt -1)
				(++ dbgMoveCnt)
			)
			(if (>= moveCnt -1)
				(-- moveCnt)
			)
		else
			(for ((= temp0 (= minTimeReq 0))) (< temp0 39) ((++ temp0))
				(+= minTimeReq (* [local39 temp0] [local0 temp0] 60))
			)
			(+= minTimeReq 3250)
		)
		(super init: &rest)
		(= global190 7)
		(if (and initialized (not moveCnt))
			(self checkTime:)
		)
	)

	(method (setKeep)
		(= keep
			(or
				(<= 6001 gNewRoomNum 6911) ; avianLeftShaft1, mirmicatPoolCloseUp
				(<= 5001 gNewRoomNum 5030) ; NYAvian1, NYAvianTetraCU
				(== gNewRoomNum 6000) ; avianShaft
				(<= 7000 gNewRoomNum 7924) ; octoAtriumRamp, ocMorphGateSW
				(<= 5301 gNewRoomNum 5331) ; NY_Octospider_Plaza_1, NY_Octospider_Plaza_31
				(<= 8000 gNewRoomNum 8130) ; HumanRamp, HumanBeds
				(<= 5202 gNewRoomNum 5215) ; humanPlazaRm2, NY_Human_Plaza_15
				(<= 5401 gNewRoomNum 5419) ; NY_Subway_1, puzzleIconCU
				(<= 5700 gNewRoomNum 5701) ; NYPort, NYPort2
				(<= 5500 gNewRoomNum 5524) ; NYMazeA, NYMazeZ
			)
		)
	)

	(method (setBombTimer param1 &tmp temp0 temp1)
		(= temp0 (if argc param1 else 21599))
		(NukeTimer setReal: NukeTimer temp0)
		(localproc_1)
		(self setMoveCnt: 0 checkTime:)
		(self setMoveCnt:)
		(= dbgMoveCnt 0)
	)

	(method (setMoveCnt param1)
		(= moveCnt (if argc param1 else 20))
	)

	(method (checkTime &tmp temp0)
		(= temp0 (- (NukeTimer seconds:) minTimeReq))
		(if (and (proc201_5) (not moveCnt) (>= temp0 2000))
			(if (!= lastSaveTime minTimeReq)
				(= lastSaveTime minTimeReq)
				(self setMoveCnt: setScript: delaySave)
			else
				(self setMoveCnt: 10)
			)
		)
	)

	(method (decMinTime param1 &tmp temp0)
		(cond
			(argc
				(if [local39 param1]
					(-- [local39 param1])
					(= temp0 (* [local0 param1] 60))
					(-= minTimeReq temp0)
				)
			)
			((> minTimeReq 10)
				(-= minTimeReq 10)
			)
		)
	)

	(method (notify param1)
		(if argc
			(switch param1
				(2
					(Sounds eachElementDo: #dispose)
					(self setScript: deathNotEternal)
				)
				(1 0)
				(3
					(Sounds eachElementDo: #dispose)
					(alarmSnd owner: self play:)
				)
			)
		)
		(super notify: &rest)
	)

	(method (dispose)
		(if (gTimers contains: NukeTimer)
			(NukeTimer client: 0 delete: dispose:)
		)
		(= local85 0)
		(super dispose: &rest)
	)

	(method (serialize param1 &tmp temp0 temp1)
		(if (and argc param1)
			(super serialize: param1 &rest)
			(self mazeSettings: (SaveManager readWord:))
			(self curAPRampPosition: (SaveManager readWord:))
			(self curAPRampDir: (SaveManager readWord:))
			(self moveCnt: (SaveManager readWord:))
			(self subPuzCU: (SaveManager readWord:))
			(self subPuzCol1: (SaveManager readWord:))
			(self subPuzCol2: (SaveManager readWord:))
			(self subPuzCol3: (SaveManager readWord:))
			(self whichSubPuz: (SaveManager readWord:))
			(self dbgMoveCnt: (SaveManager readWord:))
			(self minTimeReq: (SaveManager readWord:))
			(self lastSaveTime: (SaveManager readWord:))
			(for ((= temp1 0)) (< temp1 39) ((++ temp1))
				(= [local39 temp1] (SaveManager readWord:))
			)
			(if (and gTimers (gTimers contains: NukeTimer))
				(NukeTimer client: 0 delete: dispose:)
			)
			(if (= temp0 (SaveManager readWord:))
				(NukeTimer serialize: param1)
			)
		else
			(super serialize:)
			(SaveManager writeWord: (self mazeSettings:))
			(SaveManager writeWord: (self curAPRampPosition:))
			(SaveManager writeWord: (self curAPRampDir:))
			(SaveManager writeWord: (self moveCnt:))
			(SaveManager writeWord: (self subPuzCU:))
			(SaveManager writeWord: (self subPuzCol1:))
			(SaveManager writeWord: (self subPuzCol2:))
			(SaveManager writeWord: (self subPuzCol3:))
			(SaveManager writeWord: (self whichSubPuz:))
			(SaveManager writeWord: (self dbgMoveCnt:))
			(SaveManager writeWord: (self minTimeReq:))
			(SaveManager writeWord: (self lastSaveTime:))
			(for ((= temp1 0)) (< temp1 39) ((++ temp1))
				(SaveManager writeWord: [local39 temp1])
			)
			(if (and gTimers (gTimers contains: NukeTimer))
				(SaveManager writeWord: gTimers)
				(NukeTimer serialize: param1)
			else
				(SaveManager writeWord: 0)
			)
		)
	)
)

(instance newYorkRegion of NewYorkRegion
	(properties)
)

(instance deathNotEternal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(global123 displayOptionsText:)
				(= cycles 2)
			)
			(1
				(boomSnd setVol: 127 play:)
				(PalVary 0 201 0 80 0 192) ; PalVaryStart
				(= ticks 25)
			)
			(2
				(gCurRoom drawPic: 98)
				(if global117
					(global117 eachElementDo: #dispose)
				)
				(PalVary 1 0) ; PalVaryReverse
				(proc1111_6)
				(BOOM_Baby play:)
				(SetFlag 70)
				(gGame handsOn:)
				(gCurRoom newRoom: 95) ; morgue
			)
		)
	)
)

(instance delaySave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 2)
			)
			(1
				(gGame autoSave: 1 911)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance BOOM_Baby of VMDMovie
	(properties
		movieName 5000
		endPic 99
		cacheSize 1000
	)
)

(instance boomSnd of Sound
	(properties
		number 5014
		flags 5
	)
)

(instance gateSnd of Sound
	(properties
		flags 5
	)
)

(instance alarmSnd of Sound
	(properties
		number 5030
		flags 5
		loop -1
	)
)

