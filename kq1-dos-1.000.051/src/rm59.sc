;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 59)
(include sci.sh)
(use Main)
(use Interface)
(use rgClouds)
(use LoadMany)
(use Motion)
(use User)
(use System)

(public
	rm59 0
)

(procedure (localproc_0)
	(if (IsFlag 1)
		(gEgo view: 42)
	else
		(gEgo view: 56)
	)
)

(instance rm59 of cloudRoom
	(properties
		picture 59
		horizon 102
		east 69
		south 62
		west 58
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(LoadMany rsVIEW 42 56)
		(super init:)
		(SetFlag 0)
		(gEgo init:)
		(proc0_1)
		(switch gPrevRoomNum
			(south
				(gEgo posn: (proc0_17 242 (gEgo x:) 38) 188)
			)
			(west
				(gEgo posn: 26 (proc0_17 175 (gEgo y:) (+ horizon 2)))
			)
			(else
				(gCurRoom setScript: fadeIn)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((and (& (gEgo onControl: 1) $4000) (< (gEgo y:) 90))
				((ScriptID 0 23) loop: 1 fade:) ; backSound
				(self newRoom: east)
			)
			((& (gEgo onControl: 1) $4000)
				(self setScript: fadeOut)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(ClearFlag 0)
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look[<at,around][/room]')
				(Print 59 0) ; "You see the entrance to a cave within the mountaintop."
			)
			((Said 'look,look<in/cave')
				(if (gEgo inRect: 195 95 230 120)
					(Print 59 1) ; "It sure is dark in there!"
				else
					(Print 59 2) ; "You should try getting closer."
				)
			)
			((or (Said 'look,look/cave') (proc0_14 event 201 68 226 101))
				(Print 59 3) ; "From outside, you can see the entrance to a cave carved into the side of the mountain."
			)
			(
				(or
					(Said 'look,look/boulder')
					(proc0_14 event 205 74 305 130)
					(proc0_14 event 174 52 257 73)
					(proc0_14 event 136 75 205 105)
					(proc0_14 event 260 131 307 175)
					(proc0_14 event 164 65 205 76)
					(proc0_14 event 115 102 134 111)
				)
				(Print 59 4) ; "This is the craggy peak of Daventry's mountain. Amidst the rocks and boulders piled here, there's a dark opening leading into the mountain itself."
			)
			(
				(or
					(Said 'look,look/ceder')
					(proc0_14 event 112 29 135 48)
					(proc0_14 event 0 0 169 21)
					(proc0_14 event 0 22 86 53)
					(proc0_14 event 0 54 26 94)
					(proc0_14 event 0 95 33 180)
					(proc0_14 event 204 0 271 49)
					(proc0_14 event 299 50 320 173)
				)
				(Print 59 5) ; "There are some truly stupendous trees up here!"
			)
			(
				(or
					(Said 'look,look/cloud')
					(proc0_14 event 150 15 203 48)
					(proc0_14 event 192 173 243 183)
					(proc0_14 event 266 183 320 189)
				)
				(Print 59 6) ; "You're on top of the clouds!"
			)
		)
	)
)

(instance fadeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_0)
				(gEgo
					illegalBits: 0
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 0 cel: 0 setMotion: MoveTo 245 87 self)
			)
			(2
				(proc0_1)
				(gEgo setPri: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fadeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 7 posn: 218 100)
				(self cue:)
			)
			(1
				(localproc_0)
				(gEgo
					illegalBits: 0
					setLoop: 0
					cel: 0
					setCycle: 0
					setMotion: MoveTo 213 109 self
				)
			)
			(2
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(3
				(gEgo setLoop: -1 setPri: -1 loop: 2)
				(proc0_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

