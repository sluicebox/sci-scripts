;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene32a 0
)

(local
	local0
)

(instance Wilbur of Prop
	(properties)
)

(instance Book of Prop
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance scene32a of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(Wilbur view: 429 loop: 0 cel: 1 posn: 216 103 setPri: 1 init: stopUpd:)
		(Book view: 429 loop: 1 cel: 0 posn: 217 103 setPri: 2 init: hide:)
		(self setScript: page)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance page of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= gClarenceWilburState 4)
					(cond
						((not global216)
							(= state -1)
						)
						((not (& gMustDos $0008))
							(|= gMustDos $0008)
							(self setScript: (ScriptID 406 0)) ; Clock
							(= state -1)
						)
						((self script:)
							(= state -1)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(Print 320 0 #dispose) ; "The doctor is alone reading a magazine."
				(= seconds 4)
			)
			(2
				(Book show: cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(Book hide:)
				(= seconds 3)
			)
			(4
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

