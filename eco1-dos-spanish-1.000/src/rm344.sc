;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 344)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Talker)
(use Sound)
(use Motion)
(use System)

(public
	rm344 0
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(DrawCel 340 0 0 252 (* temp0 39) -1)
	)
)

(instance rm344 of EcoRoom
	(properties
		picture 340
		style 7
		north 660
		south 620
	)

	(method (init)
		(self setRegions: 51) ; bubblesRegion
		(gEgo init: posn: 160 -30 0 view: 805 ignoreHorizon: 1)
		(if (not (IsFlag 85))
			(gEgo setScript: whaleSoundScript)
		)
		(self setScript: enterRmScript)
		(super init:)
		(if (not (IsFlag 96))
			(localproc_0)
		)
		(gLongSong number: 332 loop: -1 play:)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (GameIsRestarting) (not (IsFlag 96)))
			(localproc_0)
		)
	)
)

(instance enterRmScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(cond
					((IsFlag 96)
						(= cycles 1)
					)
					((and (== gPrevRoomNum (gCurRoom south:)) (not (IsFlag 124)))
						(Narrator init: 1 self) ; "Following the taut cable up and up, towards the surface light..."
					)
					((== gPrevRoomNum (gCurRoom south:))
						(Narrator init: 4 self) ; "Adam follows the cable up to King Cetus."
					)
					(else
						(Narrator init: 2 self) ; "Adam follows the cable back down to the ship."
					)
				)
			)
			(2
				(switch gPrevRoomNum
					(640
						(gEgo
							setLoop: 3
							posn: 160 -30 0
							setMotion: MoveTo 160 226 self
						)
					)
					(else
						(gEgo
							setLoop: 2
							posn: 160 220 0
							setMotion: MoveTo 160 -45 self
						)
					)
				)
			)
			(3
				(if (not (SetFlag 124))
					(Narrator init: 3 self) ; "Up and up, not looking where he's going..."
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance whaleSoundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(= state -1)
				(whaleSound loop: 1 play: self)
			)
		)
	)
)

(instance whaleSound of Sound
	(properties
		number 645
	)
)

