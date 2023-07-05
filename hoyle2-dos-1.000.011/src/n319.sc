;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 319)
(include sci.sh)
(use Main)
(use Interface)

(public
	proc319_0 0
	proc319_1 1
)

(procedure (proc319_0 param1 &tmp temp0 temp1 temp2)
	(if
		(and
			(Print
				global337
				0
				#button
				{Next}
				1
				#button
				{Cancel}
				0
				#width
				250
				#title
				(gGameName text:)
				#at
				-1
				25
			)
			(Print
				global337
				1
				#button
				{Next}
				1
				#button
				{Cancel}
				0
				#width
				250
				#title
				(gGameName text:)
				#at
				-1
				25
			)
			(Print
				global337
				2
				#button
				{Next}
				1
				#button
				{Cancel}
				0
				#width
				250
				#title
				(gGameName text:)
				#at
				-1
				25
			)
		)
		(= temp1
			(if (< global337 400)
				[global430 (- global337 100)]
			else
				[global458 (- global337 400)]
			)
		)
		(= temp2
			(if (< global337 400)
				[global690 (- global337 100)]
			else
				[global718 (- global337 400)]
			)
		)
		(= temp0 (+ (* (- temp1 1) 3) (- temp2 1)))
		(Print ; "Level of play."
			319
			0
			#button
			{Done}
			1
			#title
			(gGameName text:)
			#at
			-1
			25
			#icon
			199
			temp0
			0
		)
	)
	(param1 claimed: 1)
	(DisposeScript 319)
)

(procedure (proc319_1 param1 &tmp temp0)
	(= temp0 (Format @global100 319 1 (gGameName text:) 319 2)) ; "%s %s"
	(Print 200 (mod global337 100) #button { OK } 1 #width 250 #title temp0 #at -1 25)
	(param1 claimed: 1)
	(DisposeScript 319)
)

