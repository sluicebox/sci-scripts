;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 143)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use Game)

(public
	rm143 0
)

(instance rm143 of Rgn
	(properties)

	(method (init)
		(super init:)
		(judgeBench init:)
		(flag init:)
		(spectatorArea init:)
		(wall init:)
		(table init:)
		(chairs init:)
		(aisle init:)
	)
)

(instance judgeBench of Feature
	(properties
		x 224
		y 114
		description {the bench}
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 143 0) ; "The judge's bench holds the place of honor in the courtroom."
			)
			(3 ; Do
				(Print 143 1) ; "You're not allowed up there."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flag of Feature
	(properties
		x 238
		y 69
		description {the flag}
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 143 2) ; "The U.S. flag serves to remind everyone that the courts are a branch of the local, state, and U.S. governments."
			)
			(3 ; Do
				(Print 143 3) ; "You patriotically salute the flag."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spectatorArea of Feature
	(properties
		x 65
		y 121
		description {the spectator area}
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 143 4) ; "This is the spectator area. It's usually open for the public to observe the court's proceedings."
			)
			(3 ; Do
				(Print 143 5) ; "You're happy with the seat you have."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wall of Feature
	(properties
		x 131
		y 141
		description {the wall}
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 143 6) ; "The three foot wall divides the council area from the spectator area of the courtroom."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 134
		y 103
		description {the table}
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 143 7) ; "That table is for the prosecuting attorney and the complaintent or prosecution witness."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chairs of Feature
	(properties
		x 65
		y 121
		description {the chairs}
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 143 8) ; "Theater chairs line the spectator area."
			)
			(3 ; Do
				(if (== (gEgo view:) 460)
					(Print 143 9) ; "You're happy with the seat you're in."
				else
					(Print 143 10) ; "You'll need to sit up front at the prosecutor's table."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aisle of Feature
	(properties
		x 131
		y 141
		description {the aisle}
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 143 11) ; "An aisle runs down the middle of the spectator area to the council area."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

