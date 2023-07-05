;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 195)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Motion)
(use System)

(public
	rm195 0
)

(instance myTalkerStopCheck of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

(instance rm195 of PQRoom
	(properties
		picture 195
	)

	(method (init)
		(gGame handsOff:)
		(Load rsAUDIO 19501)
		(= global432 myTalkerStopCheck)
		(super init: &rest)
		(gBackMusic number: 19501 loop: -1 play:)
		(if (and (not (IsFlag 34)) (not (IsFlag 36)) (not (IsFlag 38)))
			(self setScript: informEgo)
		else
			(self setScript: enterRange)
		)
	)

	(method (dispose)
		(= global432 0)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance informEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 1950
					posn: 69 283
					cel: 0
					init:
					setCycle: CT 19 1 self
				)
			)
			(1
				(= scratch (gNarrator modeless:))
				(gNarrator modeless: 2)
				(gMessager say: 1 0 1 1 self) ; "Say, aren't you the new guy in Sergeant Rooker's element? I hear you're suppose to be at the small Arms Range for weapons training, not over here at the Combat Range..."
				(gEgo setCycle: CT 109 1 self)
			)
			(2 0)
			(3
				(gEgo setCycle: CT 112 1 self)
			)
			(4
				(gMessager say: 1 0 1 2 self) ; "Hey, thanks..."
				(gEgo setCycle: End self)
			)
			(5 0)
			(6
				(gNarrator modeless: scratch)
				(= cycles 2)
			)
			(7
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance enterRange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 1951
					loop: 0
					cel: 0
					posn: 125 268
					init:
					setPri: 100
					setCycle: End self
				)
			)
			(1
				(gCurRoom newRoom: 196)
			)
		)
	)
)

