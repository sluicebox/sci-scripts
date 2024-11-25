;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use Gaza)
(use desertReg)
(use eRoom)
(use Interface)
(use Follow)
(use Motion)
(use System)

(public
	Rm39 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(switch global165
		(0
			(if
				(and
					(== global165 0)
					(< global162 20)
					(not
						(and
							(== global165 0)
							(== global162 15)
							(not local2)
							(not local3)
						)
					)
				)
				(-- local2)
				(+= global162 80)
			else
				(-= global162 10)
			)
		)
		(2
			(if
				(and
					(== global165 2)
					(> global162 90)
					(not
						(and
							(== global165 2)
							(== global162 95)
							(not local2)
							(not local3)
						)
					)
				)
				(++ local2)
				(-= global162 80)
			else
				(+= global162 10)
			)
		)
		(1
			(if
				(and
					(== global165 1)
					(== (mod global162 10) 9)
					(not
						(and
							(== global165 1)
							(== global162 59)
							(not local2)
							(not local3)
						)
					)
				)
				(++ local3)
				(-= global162 8)
			else
				(+= global162 1)
			)
		)
		(3
			(if
				(and
					(== global165 3)
					(== (mod global162 10) 1)
					(not
						(and
							(== global165 3)
							(== global162 51)
							(not local2)
							(not local3)
						)
					)
				)
				(-- local3)
				(+= global162 8)
			else
				(-= global162 1)
			)
		)
	)
)

(instance Rm39 of eRoom
	(properties
		picture 39
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 129)
		(DisposeScript 140)
		(DisposeScript 143)
	)

	(method (init)
		(Load rsSCRIPT 129)
		(Load rsSCRIPT 140)
		(Load rsSCRIPT 143)
		(Load rsPIC 112)
		(Load rsVIEW 148)
		(Load rsVIEW 39)
		(Load rsVIEW 139)
		(self
			style:
				(switch global103
					(0 100)
					(1 15)
					(2 17)
				)
		)
		(super init:)
		(self setRegions: 107) ; Gaza
		(self setRegions: 129) ; desertReg
		(if (IsFlag 20)
			(= local0 1)
		)
		(= global163 0)
		(= local4 gPrevRoomNum)
		(switch gPrevRoomNum
			(38
				(= global165 1)
				(= global164 3)
			)
			(40
				(= global165 3)
				(= global164 1)
			)
			(44
				(= global165 0)
				(= global164 2)
			)
			(48
				(= global165 2)
				(= global164 0)
			)
		)
		(proc129_3)
		(gEgo init:)
		(switch gPrevRoomNum
			(48
				(if local0
					(self muleEnterRoom: 140 -5 140 50)
				)
				(self enterRoom: 215 -5 215 57)
				(= global162 15)
			)
			(44
				(if local0
					(self muleEnterRoom: 130 220 130 188)
				)
				(self enterRoom: 160 235 160 182)
				(= global162 95)
			)
			(40
				(if local0
					(self muleEnterRoom: 320 120 285 120)
				)
				(self enterRoom: 320 110 290 110)
				(= global162 59)
			)
			(else
				(if local0
					(self muleEnterRoom: -5 120 25 120)
				)
				(self enterRoom: -10 110 20 110)
				(= global162 51)
			)
		)
		(proc0_13 65)
		(gAddToPics doit:)
		(if (and (== (Random 1 3) 1) (not (IsFlag 98)))
			((ScriptID 140 0) init:) ; lizard
		)
	)

	(method (doit)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((IsFlag 99)
					(ClearFlag 99)
					((ScriptID 141 0) init:) ; lovers
				)
				((IsFlag 100)
					(ClearFlag 100)
					((ScriptID 145 0) init:) ; water
				)
				(
					(and
						local0
						(gEgo mover:)
						(> (gEgo distanceTo: gMuleObj) 50)
						(not (gMuleObj mover:))
						(not (gEgo script:))
						(not (IsFlag 103))
						(not local1)
					)
					(gMuleObj setMotion: Follow gEgo 50)
				)
				(
					(and
						(not script)
						(or
							(< (gEgo y:) 40)
							(> (gEgo y:) 185)
							(< (gEgo x:) 10)
							(> (gEgo x:) 310)
						)
					)
					(self setScript: changeRooms)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((and gModelessDialog (not (gEgo script:)))
				((ScriptID 141 0) handleEvent: event) ; lovers
			)
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(and
							(or
								(== global162 15)
								(== global162 51)
								(== global162 59)
								(== global162 95)
							)
							(or
								(OnButton event 67 108 90 120)
								(OnButton event 131 110 229 138)
								(OnButton event 189 151 209 162)
								(OnButton event 142 24 184 36)
								(OnButton event 230 25 264 43)
							)
						)
						(proc107_2)
					)
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/desert,gaza,terrain')
							(Said '//desert,gaza,terrain')
						)
						(if local4
							(if (== local4 40)
								(Print 39 0) ; "Beware! Ahead of you is only vast and open desert. This is no time to get lost."
							else
								(Print 39 1) ; "There are rocks, barren ground and sand, and a vast array of desert stretching out in all directions, save for the way you came."
							)
						else
							(Print 39 2) ; "There are rocks, barren ground and sand, and a vast array of desert stretching out in all directions."
						)
					)
				)
			)
		)
	)
)

(instance changeRooms of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local1 1)
				(if local0
					(gMuleObj setMotion: 0)
					(DisposeScript 971)
				)
				(proc129_1)
				(if
					(or
						(and
							(== global165 3)
							(== global162 51)
							(not local2)
							(not local3)
						)
						(and
							(== global165 1)
							(== global162 59)
							(not local2)
							(not local3)
						)
						(and
							(== global165 2)
							(== global162 95)
							(not local2)
							(not local3)
						)
						(and
							(== global165 0)
							(== global162 15)
							(not local2)
							(not local3)
						)
					)
					(proc129_9)
					(= global61 0)
					(cond
						(
							(and
								(== global165 3)
								(== global162 51)
								(not local2)
								(not local3)
							)
							(= temp0 38)
						)
						(
							(and
								(== global165 1)
								(== global162 59)
								(not local2)
								(not local3)
							)
							(= temp0 40)
						)
						(
							(and
								(== global165 2)
								(== global162 95)
								(not local2)
								(not local3)
							)
							(= temp0 44)
						)
						(
							(and
								(== global165 0)
								(== global162 15)
								(not local2)
								(not local3)
							)
							(= temp0 48)
						)
					)
					(cond
						((< (gEgo y:) 40)
							(client leaveRoom: temp0 (gEgo x:) -5)
						)
						((> (gEgo x:) 310)
							(client leaveRoom: temp0 320 (gEgo y:))
						)
						((> (gEgo y:) 185)
							(client leaveRoom: temp0 (gEgo x:) 235)
						)
						((< (gEgo x:) 10)
							(client leaveRoom: temp0 -10 (gEgo y:))
						)
					)
					(client setScript: 0)
				else
					(localproc_0)
					(cond
						((< (gEgo y:) 40)
							(gEgo
								illegalBits: 0
								ignoreActors: 1
								setMotion: MoveTo (gEgo x:) -5 self
							)
						)
						((> (gEgo y:) 185)
							(gEgo
								illegalBits: 0
								ignoreActors: 1
								setMotion: MoveTo (gEgo x:) 235 self
							)
						)
						((< (gEgo x:) 10)
							(gEgo
								illegalBits: 0
								ignoreActors: 1
								setMotion: MoveTo -10 (gEgo y:) self
							)
						)
						((> (gEgo x:) 310)
							(gEgo
								illegalBits: 0
								ignoreActors: 1
								setMotion: MoveTo 320 (gEgo y:) self
							)
						)
					)
				)
			)
			(1
				(proc129_9)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 112)
				(proc129_5)
				(gMuleObj hide:)
				(self cue:)
			)
			(3
				(= global164 (mod (+ global165 2) 4))
				(if
					(and
						(not local2)
						(not local3)
						(or
							(== global162 15)
							(== global162 95)
							(== global162 51)
							(== global162 59)
						)
					)
					(= global61 0)
					(= global163 0)
					(gCurRoom drawPic: 39)
				else
					(= global163 (Random 0 3))
					(proc129_6)
					(proc129_4)
					(proc129_7)
					(switch global163
						(1
							(= global61 2)
						)
						(2
							(= global61 1)
						)
						(3
							(= global61 3)
						)
						(0
							(= global61 0)
						)
					)
					(gCurRoom drawPic: 84)
				)
				(proc0_13 65)
				(gAddToPics doit:)
				(= cycles 2)
			)
			(4
				(proc129_8)
			)
			(5
				(gEgo illegalBits: $8000 ignoreActors: 0)
				(= local1 0)
				(= local4 0)
				(HandsOn)
				(cond
					((and (< global204 1000) (== (Random 1 2) 1))
						((ScriptID 140 0) init:) ; lizard
					)
					((and (< global204 2000) (== (Random 1 3) 1))
						((ScriptID 140 0) init:) ; lizard
					)
					((== (Random 1 4) 1)
						((ScriptID 140 0) init:) ; lizard
					)
					((and (not (IsFlag 110)) (IsFlag 98))
						((ScriptID 141 0) init:) ; lovers
					)
					((and (IsFlag 98) (== (Random 1 3) 1))
						((ScriptID 145 0) init:) ; water
					)
				)
				(client setScript: 0)
			)
		)
	)
)

