;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Rev)
(use Follow)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm63 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance twister of Act
	(properties)
)

(instance tumbler of Act
	(properties)
)

(instance swimmer of Act
	(properties)
)

(instance rm63 of Rm
	(properties
		picture 701
		style 8
		horizon 90
		north 51
		east 64
		south 71
		west 62
	)

	(method (dispose)
		(SetFlag 53)
		(super dispose:)
	)

	(method (init)
		(if gNight
			(Load rsSCRIPT 805)
		)
		(super init: &rest)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(gEgo init:)
		(if gNight
			(switch (Random 1 5)
				(1
					(twister init: setScript: twistIt)
				)
				(2
					(tumbler init: setScript: spinAcross)
				)
				(3
					(swimmer init: setScript: swimLeft)
				)
				(4
					(twister init: setScript: twistIt)
				)
				(5
					(swimmer init: setScript: swimRight)
				)
			)
		)
		(switch gPrevRoomNum
			(51
				(gEgo posn: 180 92 setMotion: MoveTo 180 190)
			)
			(62
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(64
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(71
				(gEgo posn: 160 188 setMotion: MoveTo 160 0)
			)
		)
		(self setRegions: 806) ; Cemetery
	)
)

(instance twistIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(twister
					view: 64
					setLoop: 0
					setPri: 12
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: 155 -10
					cycleSpeed: 1
					setCycle: Fwd
					startUpd:
					setMotion: MoveTo 200 50 self
				)
				(= local0 (twister x:))
				(= local1 (twister y:))
			)
			(1
				(= local2 local0)
				(= local3 local1)
				(= local0 (Random 20 300))
				(= local1 (Random 10 130))
				(twister setCycle: (if (> local0 local2) Fwd else Rev))
				(if (IsFlag 164)
					(twister setMotion: Follow gEgo 30)
				else
					(twister setMotion: MoveTo local0 local1 self)
				)
			)
			(2
				(if
					(or
						(< (twister x:) 30)
						(> (twister x:) 290)
						(< (twister y:) 20)
					)
					(self cue:)
				else
					(self changeState: 1)
				)
			)
			(3
				(twister
					setMotion:
						MoveTo
						(cond
							((< (twister y:) 20)
								(twister x:)
							)
							((< (twister x:) 30) -20)
							((> (twister x:) 290) 340)
						)
						(if (< (twister y:) 20)
							-10
						else
							(twister y:)
						)
						self
				)
			)
			(4
				(-- global320)
				(twister stopUpd: setScript: 0)
			)
		)
	)
)

(instance spinAcross of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tumbler
					view: 64
					setLoop: 8
					setPri: 7
					setStep: 5 3
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: -15 (Random 40 110)
					setCycle: Fwd
					startUpd:
				)
				(if (IsFlag 164)
					(tumbler setMotion: Follow gEgo 30)
				else
					(tumbler setMotion: MoveTo 345 (Random 0 80) self)
				)
			)
			(1
				(-- global320)
				(tumbler stopUpd: setScript: 0)
			)
		)
	)
)

(instance spinOnTree of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tumbler
					view: 64
					setLoop: 8
					setStep: 5 3
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: 253 -10
					setCel: 0
					setMotion: MoveTo 253 39
					startUpd:
				)
				(= cycles 35)
			)
			(1
				(++ local4)
				(tumbler setCel: -1 setCycle: End self)
			)
			(2
				(if (> local4 (Random 2 4))
					(tumbler setCycle: Fwd)
					(if (IsFlag 164)
						(tumbler setMotion: Follow gEgo 30)
					else
						(tumbler setMotion: MoveTo -15 (Random 40 110) self)
					)
				else
					(self changeState: 1)
				)
			)
			(3
				(-- global320)
				(tumbler stopUpd: setScript: 0)
			)
		)
	)
)

(instance swimRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swimmer
					view: 64
					setStep: 6 4
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					setLoop: 1
					cycleSpeed: 1
					setCycle: Fwd
					posn: -15 (Random 25 65)
					startUpd:
				)
				(if (IsFlag 164)
					(swimmer setMotion: Follow gEgo 30)
				else
					(swimmer setMotion: MoveTo 350 (Random 85 125) self)
				)
			)
			(1
				(-- global320)
				(swimmer stopUpd: setScript: 0)
			)
		)
	)
)

(instance swimLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swimmer
					view: 64
					setStep: 6 4
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					setLoop: 2
					cycleSpeed: 1
					setCycle: Fwd
					posn: 325 (Random -10 10)
					startUpd:
				)
				(if (IsFlag 164)
					(swimmer setMotion: Follow gEgo 30)
				else
					(swimmer
						setMotion: MoveTo (Random 115 145) (Random 55 85) self
					)
				)
			)
			(1
				(swimmer setMotion: MoveTo (Random 30 65) -10 self)
			)
			(2
				(-- global320)
				(swimmer stopUpd: setScript: 0)
			)
		)
	)
)

