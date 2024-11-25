;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 602)
(include sci.sh)
(use Main)
(use LoadMany)
(use Game)
(use System)

(public
	rgMenace 0
	startScript 1
	waitAFew 2
)

(local
	local0
	local1
)

(instance rgMenace of Rgn
	(properties)

	(method (init)
		(self keep: 0)
		(super init:)
		(LoadMany rsSCRIPT 985 982 972)
		(switch gPrevRoomNum
			((gCurRoom north:) 0)
			((gCurRoom south:) 0)
			((gCurRoom west:) 0)
			((gCurRoom east:) 0)
			(else
				(= local1 1)
			)
		)
		(= global138 0)
		(= global139 0)
		(switch
			(cond
				(local1
					(switch gCurRoomNum
						(29 0)
						(46 2)
						(35 1)
					)
				)
				((gEgo has: 16) ; Magic_Shield
					(Random 0 1)
				)
				(else
					(Random 0 2)
				)
			)
			(0
				(LoadMany rsSOUND 34 26 90)
				(LoadMany rsVIEW 100 101 28 102)
				(Load rsSCRIPT 800)
				(= global125 800)
				(if
					(not
						(and
							(gEgo has: 14) ; Magic_Mirror
							(gEgo has: 16) ; Magic_Shield
							(gEgo has: 1) ; Chest
						)
					)
					(switch (Random 0 3)
						(1
							(Load rsVIEW 135)
							(Load rsSOUND 93)
							(Load rsSCRIPT 804)
							(= global138 804)
						)
						(3
							(LoadMany rsVIEW 130 20)
							(Load rsSOUND 35)
							(Load rsSCRIPT 803)
							(= global138 803)
						)
						(else
							(= global138 0)
						)
					)
				)
			)
			(1
				(Load rsVIEW 135)
				(Load rsSOUND 93)
				(Load rsSCRIPT 804)
				(= global125 804)
			)
			(2
				(LoadMany rsVIEW 130 20)
				(Load rsSOUND 35)
				(Load rsSCRIPT 803)
				(= global125 803)
			)
		)
		(gMenace
			illegalBits: $c000
			setLoop: -1
			setCel: -1
			setPri: -1
			cycleSpeed: 0
			moveSpeed: 0
		)
		(self setScript: waitOne)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(DisposeScript global125)
		(if global138
			(DisposeScript global138)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
	)
)

(instance waitOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(if
					(and
						(gEgo inRect: 20 (+ (gCurRoom horizon:) 12) 300 176)
						(not (IsFlag 1))
						(not global124)
						(not (gCurRoom script:))
						(not (gEgo script:))
						(== gNewRoomNum gCurRoomNum)
					)
					(gCurRoom setScript: startScript)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance startScript of Script
	(properties)

	(method (dispose)
		((ScriptID 0 23) number: 2 loop: -1 playBed: fade: 127 25 19 0) ; backSound
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID global125 0) self)
			)
			(1
				(if global138
					0
				else
					(self dispose:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance waitAFew of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(self setScript: (ScriptID global138 0) self)
			)
			(2
				(startScript cue:)
				((ScriptID global125 0) cue:)
				(self dispose:)
			)
		)
	)
)

