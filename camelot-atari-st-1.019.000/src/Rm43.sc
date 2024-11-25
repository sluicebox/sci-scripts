;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
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
	Rm43 0
)

(local
	local0
	local1
	local2
	local3
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
			(if (and (== global165 2) (> global162 90))
				(++ local2)
				(-= global162 80)
			else
				(+= global162 10)
			)
		)
		(1
			(if (and (== global165 1) (== (mod global162 10) 9))
				(++ local3)
				(-= global162 8)
			else
				(+= global162 1)
			)
		)
		(3
			(if (and (== global165 3) (== (mod global162 10) 1))
				(-- local3)
				(+= global162 8)
			else
				(-= global162 1)
			)
		)
	)
)

(instance Rm43 of eRoom
	(properties
		picture 43
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 129)
		(DisposeScript 140)
		(DisposeScript 143)
	)

	(method (init)
		(self
			style:
				(switch global103
					(0 100)
					(1 15)
					(2 17)
				)
		)
		(Load rsSCRIPT 129)
		(Load rsSCRIPT 140)
		(Load rsSCRIPT 143)
		(Load rsPIC 112)
		(Load rsVIEW 148)
		(Load rsVIEW 39)
		(Load rsVIEW 139)
		(super init:)
		(self setRegions: 107) ; Gaza
		(self setRegions: 129) ; desertReg
		(if (IsFlag 20)
			(= local0 1)
		)
		(= global165 2)
		(= global164 0)
		(= global163 0)
		(proc129_3)
		(gEgo init:)
		(if local0
			(self muleEnterRoom: 280 -5 280 50)
		)
		(self enterRoom: 250 -5 250 60)
		(= global162 15)
		(proc0_13 65)
		(gAddToPics doit:)
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
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/desert,gaza,terrain,cliff,mesa')
							(Said '//desert,gaza,terrain,cliff,mesa')
							(OnButton event 0 0 157 51)
						)
						(if (== global162 15)
							(Print 43 0) ; "The cliffs end and a huge, flat expanse of searing desert opens out before you."
						else
							(Print 43 1) ; "There are rocks, barren ground and sand, and a vast array of desert stretching out in all directions."
						)
					)
					(
						(and
							(== global162 15)
							(or
								(OnButton event 53 133 108 150)
								(OnButton event 130 120 152 135)
								(OnButton event 152 101 240 134)
								(OnButton event 245 83 290 96)
								(OnButton event 185 163 198 171)
								(OnButton event 245 162 286 173)
								(OnButton event 77 59 111 66)
								(OnButton event 147 57 163 67)
								(OnButton event 192 33 211 42)
							)
						)
						(proc107_2)
					)
				)
			)
		)
	)
)

(instance changeRooms of Script
	(properties)

	(method (changeState newState)
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
					(and
						(== global165 0)
						(== global162 15)
						(not local2)
						(not local3)
					)
					(proc129_9)
					(= global61 0)
					(cond
						((< (gEgo y:) 40)
							(client leaveRoom: 42 (gEgo x:) -5)
						)
						((> (gEgo x:) 310)
							(client leaveRoom: 42 320 (gEgo x:))
						)
						((> (gEgo y:) 185)
							(client leaveRoom: 42 (gEgo x:) 235)
						)
						((< (gEgo x:) 10)
							(client leaveRoom: 42 -10 (gEgo y:))
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
				(if (and (== global162 15) (not local2) (not local3))
					(= global163 0)
					(= global61 0)
					(gCurRoom drawPic: 43)
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
				(= local1 0)
				(gEgo illegalBits: $8000 ignoreActors: 0)
				(HandsOn)
				(if (not (and (== global162 15) (not local2) (not local3)))
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
				)
				(client setScript: 0)
			)
		)
	)
)

