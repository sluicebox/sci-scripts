;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 699)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room699 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	[local9 3]
)

(instance Room699 of Rm
	(properties
		picture 96
		style 6
	)

	(method (init)
		(Load rsVIEW 879)
		(super init:)
		((View new:) view: 879 loop: 0 cel: 0 posn: 124 192 addToPic:)
		((View new:) view: 879 loop: 0 cel: 1 posn: 165 192 addToPic:)
		((View new:) view: 879 loop: 0 cel: 2 posn: 206 192 addToPic:)
		(= local5 gDeathFlag)
		(= gDeathFlag 0)
		(playMusic cue:)
		((= local0 (Prop new:))
			view: 879
			setLoop: 2
			setPri: 15
			setScript: spark1
		)
		((= local1 (Prop new:))
			view: 879
			setLoop: 2
			setPri: 15
			setScript: spark2
		)
		((= local2 (Prop new:))
			view: 879
			setLoop: 2
			setPri: 15
			setScript: spark3
		)
		((= local3 (Prop new:))
			view: 879
			setLoop: 2
			setPri: 15
			setScript: spark4
		)
	)

	(method (doit)
		(if (== local7 0)
			(if (== (Print 699 0 #time 10 #button {Yes} 1 #button {No} 2) 2) ; "Is this your first time playing King's Quest IV?"
				(gGame restart:)
			)
			(= local7 1)
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(event claimed: 1)
		(= local8 0)
		(if local5
			(= local5 0)
			(gGame restart:)
		)
		(if (or (== (event message:) KEY_x) (== (event message:) KEY_X))
			(gGame restart:)
		else
			(gCast eachElementDo: #dispose)
			(gCurRoom newRoom: 698)
		)
	)
)

(instance spark1 of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(client init:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (/ (Random 10 40) 10))
				(client
					posn:
						(switch temp0
							(1 96)
							(2 135)
							(3 230)
							(4 260)
							(else 150)
						)
						(switch temp0
							(1 39)
							(2 158)
							(3 18)
							(4 123)
							(else 100)
						)
					show:
					cycleSpeed: (Random 0 2)
					setCycle: End self
				)
			)
			(1
				(client hide:)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance spark2 of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(client init:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (/ (Random 10 40) 10))
				(client
					posn:
						(switch temp0
							(1 80)
							(2 204)
							(3 141)
							(4 267)
						)
						(switch temp0
							(1 83)
							(2 121)
							(3 80)
							(4 97)
						)
					show:
					cycleSpeed: (Random 0 2)
					setCycle: End self
				)
			)
			(1
				(client hide:)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance spark3 of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(client init:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (/ (Random 10 40) 10))
				(client
					posn:
						(switch temp0
							(1 197)
							(2 182)
							(3 116)
							(4 104)
						)
						(switch temp0
							(1 47)
							(2 158)
							(3 49)
							(4 185)
						)
					show:
					cycleSpeed: (Random 0 2)
					setCycle: End self
				)
			)
			(1
				(client hide:)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance spark4 of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(client init:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (/ (Random 10 40) 10))
				(client
					posn:
						(switch temp0
							(1 141)
							(2 102)
							(3 268)
							(4 210)
						)
						(switch temp0
							(1 80)
							(2 117)
							(3 96)
							(4 112)
						)
					show:
					cycleSpeed: (Random 0 2)
					setCycle: End self
				)
			)
			(1
				(client hide:)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance bannerSound of Sound
	(properties
		number 1
	)
)

(instance playMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bannerSound loop: 1 play: self)
			)
			(1
				(gCurRoom newRoom: 698)
			)
		)
	)
)

