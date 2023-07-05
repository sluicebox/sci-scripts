;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 131)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	keyPadBut 0
)

(class keyPadBut of Prop
	(properties
		priority 15
		signal 17
		cycleSpeed 1
		number 0
		keyEquiv 0
		whoCalled 0
		soundNum 0
		playSound 0
	)

	(method (init param1)
		(super init:)
		(self whoCalled: param1)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (not playSound) (OneOf gCurRoomNum 20 21))
			(return 0)
		else
			(switch (event type:)
				(evKEYBOARD
					(cond
						((== (event message:) keyEquiv)
							(self setCycle: Beg)
							(whoCalled register: (self number:))
							(if playSound
								(gLongSong
									loop: 1
									number: (self soundNum:)
									play:
								)
							)
							(event claimed: 1)
						)
						(
							(and
								(InRect nsLeft nsTop nsRight nsBottom event)
								(== (event message:) KEY_RETURN)
							)
							(self setCycle: Beg)
							(whoCalled register: (self number:))
							(if playSound
								(gLongSong
									loop: 1
									number: (self soundNum:)
									play:
								)
							)
							(event claimed: 1)
						)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self setCycle: Beg)
						(whoCalled register: (self number:))
						(if playSound
							(gLongSong loop: 1 number: (self soundNum:) play:)
						)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

