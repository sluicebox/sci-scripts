;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Interface)
(use Rev)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	bHatchTubeRm 0
)

(instance bHatchTubeRm of Rm
	(properties
		picture 42
		north 41
		east 33
		west 35
	)

	(method (init)
		(super init:)
		(gEgo init:)
		(eastDoor init:)
		(westDoor init:)
		(self
			setScript:
				(switch gPrevRoomNum
					(east cameFromEastScript)
					(west cameFromWestScript)
					(north cameFromNorthScript)
				)
				self
		)
	)

	(method (cue)
		(self setScript: roomControlScript)
	)

	(method (newRoom newRoomNumber)
		(gEgo setPri: -1 setLoop: -1 setCycle: Walk)
		(HandsOn)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene]')
				(Print 42 0) ; "This hacthtube leads to the torpedo room on the right, and the storage room on the left."
			)
		)
	)
)

(instance cameFromNorthScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					posn: 124 27
					setCycle: Rev
					setLoop: 3
					setMotion: MoveTo 124 95 self
				)
			)
			(1
				(gEgo
					setCycle: Walk
					heading: 0
					observeControl: -32768
					setLoop: -1
					setLoop: Grooper
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cameFromEastScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					loop: 1
					cel: 7
					posn: 159 104
					setMotion: MoveTo 144 104 self
				)
				(eastDoor posn: 151 51 setMotion: MoveTo 151 101 self)
			)
			(1)
			(2
				(eastDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cameFromWestScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					loop: 0
					cel: 7
					posn: 89 104
					setMotion: MoveTo 104 104 self
				)
				(westDoor posn: 95 51 setMotion: MoveTo 95 101 self)
			)
			(1)
			(2
				(westDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance roomControlScript of Script
	(properties)

	(method (doit)
		(cond
			((< (gEgo x:) 104)
				(client setScript: goWestScript)
			)
			((> (gEgo x:) 144)
				(client setScript: goEastScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'go,climb[<up][/ladder]')
				(gEgo setScript: climbStairsScript)
				(self dispose:)
			)
		)
	)
)

(instance goWestScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 89 102 self)
				(westDoor setMotion: MoveTo 95 51 self)
			)
			(1)
			(2
				(gCurRoom newRoom: (gCurRoom west:))
			)
		)
	)
)

(instance goEastScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 159 102 self)
				(eastDoor setMotion: MoveTo 151 51 self)
			)
			(1)
			(2
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance climbStairsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 124 97 self)
			)
			(1
				(gEgo
					heading: 0
					ignoreControl: -32768
					setMotion: MoveTo 124 27 self
				)
			)
			(2
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance eastDoor of Act
	(properties
		y 101
		x 151
		view 41
	)

	(method (setMotion)
		(super setMotion: &rest)
		(doorSound number: (proc0_5 13) play:)
	)

	(method (stopUpd)
		(super stopUpd:)
		(doorSound number: (proc0_5 19) play:)
	)

	(method (init)
		(super init:)
		(self setPri: 14 ignoreActors: 1 ignoreControl: -32768)
	)
)

(instance westDoor of Act
	(properties
		y 101
		x 95
		view 41
		cel 1
	)

	(method (setMotion)
		(super setMotion: &rest)
		(doorSound number: (proc0_5 13) play:)
	)

	(method (stopUpd)
		(super stopUpd:)
		(doorSound number: (proc0_5 19) play:)
	)

	(method (init)
		(super init:)
		(self setPri: 14 ignoreActors: 1 ignoreControl: -32768)
	)
)

(instance doorSound of Sound
	(properties
		number 19
		priority 2
	)
)

