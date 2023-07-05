;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use Interface)
(use scubaRg)
(use Motion)
(use Game)

(public
	shoreRm 0
)

(instance shoreRm of Rm
	(properties
		picture 54
		north 999
		east 61
		south 51
		west 53
	)

	(method (init)
		(super init:)
		(self setRegions: 305) ; scubaRg
		(gEgo init:)
		(switch gPrevRoomNum
			(61 ; tunisBeachRm
				(gEgo x: 310 loop: 1 setMotion: MoveTo -5 (gEgo y:))
			)
			(53 ; antiSubNetRm
				(gEgo x: 10 loop: 0 setMotion: MoveTo 325 (gEgo y:))
			)
			(else
				(gEgo posn: 199 185 loop: 3 setMotion: MoveTo 199 -5)
			)
		)
		(proc305_1 3 0 147 97 6)
		(proc305_1 1 0 49 146 10)
		(proc305_1 1 0 83 84)
		(proc305_1 3 1 25 132 9)
		(proc305_1 2 2 162 158 12)
		(proc305_1 2 0 265 184 14)
		(proc305_1 4 1 118 156 11)
		(proc305_2 5 176 154 11)
		(proc305_2 6 79 165 12)
		(proc305_2 6 22 185 14)
		(proc305_2 6 284 179 14)
		(proc305_2 8 283 106 7)
		(proc305_2 8 319 104 6)
		(proc305_2 8 79 158 11)
		(proc305_2 8 130 93 5)
		(proc305_2 8 285 81 4)
		(proc305_2 6 259 79 4)
		(proc305_2 6 177 93 5)
		(proc305_2 5 55 77 4)
		(gAddToPics doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look>')
				(cond
					((Said '[<at,around][/room]')
						(switch (Random 0 3)
							(0
								(Print 54 0) ; "You see nothing of significance."
							)
							(1
								(Print 54 1) ; "Searching, you find nothing."
							)
							(2
								(Print 54 2) ; "You look, but nothing here will help you."
							)
							(3
								(Print 54 3) ; "Looks like normal seascape for the area."
							)
						)
					)
					((Said '/cave')
						(Print 54 4) ; "You search for a cave but find none."
					)
					((Said '/rock')
						(switch (Random 0 1)
							(0
								(Print 54 5) ; "You look but see only a couple of star fish."
							)
							(1
								(Print 54 6) ; "You look behind the rock and see nothing."
							)
						)
					)
					(else
						(Print 54 7) ; "You look but find nothing that will help you."
					)
				)
			)
			((Said 'get')
				(Print 54 8) ; "You don't need it."
			)
			((Said 'move>')
				(if (Said '/rock')
					(Print 54 9) ; "Moving the rock would be useless."
				else
					(Print 54 10) ; "You're wasting your time trying to move it."
				)
			)
		)
	)
)

