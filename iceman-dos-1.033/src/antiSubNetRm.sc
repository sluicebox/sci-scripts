;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Interface)
(use scubaRg)
(use n821)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	antiSubNetRm 0
)

(local
	local0
	local1
)

(instance antiSubNetRm of Rm
	(properties
		picture 53
		north 45
		east 54
		south 51
		west 55
	)

	(method (init)
		(super init:)
		(self setRegions: 305) ; scubaRg
		(gEgo init:)
		(proc305_2 5 160 116 8)
		(proc305_2 5 209 119 8)
		(proc305_2 5 39 130 9)
		(proc305_2 5 24 61 2)
		(proc305_2 6 97 167 12)
		(proc305_2 6 125 131 9)
		(proc305_2 7 291 167 12)
		(proc305_2 6 49 178 13)
		(proc305_2 6 309 66 3)
		(proc305_1 4 1 288 68)
		(gAddToPics doit:)
		(switch gPrevRoomNum
			(54 ; shoreRm
				(if (< (gEgo y:) 55)
					(gEgo x: 310 y: 58 loop: 1 setMotion: MoveTo -5 58)
				else
					(gEgo x: 310 loop: 1 setMotion: MoveTo -5 (gEgo y:))
				)
			)
			(55 ; shore2Rm
				(if (< 50 (gEgo y:))
					(gEgo x: 10 loop: 0 setMotion: MoveTo 325 (gEgo y:))
				else
					(gEgo x: 10 y: 70 loop: 0 setMotion: MoveTo 325 70)
				)
			)
			(68 ; caveExitRm
				(HandsOff)
				(gEgo illegalBits: 0 posn: 1 33 setScript: exitCave)
			)
			(45 ; netBeachRm
				(gEgo posn: 160 4 loop: 2 setMotion: MoveTo 160 200)
			)
			(else
				(gEgo posn: 160 174 loop: 3 setMotion: MoveTo 160 -5)
			)
		)
	)

	(method (doit)
		(cond
			((and local0 (< (gEgo y:) 40))
				(= local0 0)
				(gGame changeScore: 1)
			)
			((and local1 (< 60 (gEgo y:)))
				(= local1 0)
				(gGame changeScore: -11)
			)
			(
				(and
					(< 45 (gEgo y:) 55)
					(not (gEgo script:))
					(not local1)
					(not local0)
				)
				(gEgo setScript: hitNet)
			)
		)
		(if
			(and
				(< (gEgo y:) 43)
				(< (gEgo x:) 48)
				(not (gEgo script:))
			)
			(gEgo setScript: enterCave)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '(turn<on),use,activate/device')
				(cond
					((not (gEgo has: 8)) ; Sub: Device | Tunisia: Tranquilizer_Gun
						(Print 53 0) ; "You don't have one of those."
					)
					((or local0 local1)
						(Print 53 1) ; "The device is on."
					)
					(else
						(Print 53 2) ; "You activate the electronic device."
						(if (< 54 (gEgo y:))
							(= local0 1)
						else
							(= local1 1)
						)
					)
				)
			)
			((Said '(turn<off),stop/device')
				(cond
					((or local0 local1)
						(== local0 0)
						(== local1 0)
					)
					((gEgo has: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
						(Print 53 3) ; "It's not on."
					)
					(else
						(Print 53 4) ; "You don't have one."
					)
				)
			)
		)
	)
)

(instance leftNet of Feature ; UNUSED
	(properties
		y 100
		x 30
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look<through/net')
				(Print 53 5) ; "Through the net you see what appears to be the entrance to a cave."
				(Print 53 6) ; "You think to yourself, "I wonder where the other end of that cave might be?""
			)
		)
	)
)

(instance rightNet of Feature ; UNUSED
	(properties
		y 100
		x 230
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look<through/net')
				(Print 53 7) ; "You look through the net to the other side but can't see anything of significance."
			)
		)
	)
)

(instance exitCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 100 33 self)
			)
			(1
				(gEgo illegalBits: -32768 setMotion: MoveTo 280 -5 self)
			)
			(2
				(HandsOn)
				(antiSubNetRm newRoom: 55) ; shore2Rm
			)
		)
	)
)

(instance enterCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(antiSubNetRm newRoom: 68) ; caveExitRm
			)
		)
	)
)

(instance hitNet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 53 8) ; "You feel a tug on your scuba vehicle and realize that you have been detected by some magnetic field across the harbor entrance."
				(EgoDead 157 0 0 53 9) ; "Forced to the surface by enemy scuba divers, you are captured."
			)
		)
	)
)

