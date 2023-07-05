;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 471)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use System)

(public
	postCard 0
)

(instance postCard of Code
	(properties)

	(method (init)
		(Load rsVIEW (LangSwitch 73 318))
		(super init:)
	)

	(method (doit)
		(gGame setCursor: gNormalCursor 1)
		(switch global600
			(1
				(Print ; "You examine one of the many interesting post cards."
					471
					0
					#icon
					(LangSwitch 73 318)
					0
					2
					#width
					100
					#button
					{Read Back}
					1
				)
				(Print 471 1 #font 999 #width 225) ; "Arrakis               Place A great spot for winter travel,       Stamp Arrakis holds many delights for        Here the adventurous vacationer. Nothing can compare with a blinding dust storm, or being crushed by a sandworm."
			)
			(2
				(Print ; "You examine one of the many interesting post cards."
					471
					0
					#icon
					(LangSwitch 73 318)
					1
					1
					#width
					100
					#button
					{Read Back}
					1
				)
				(Print 471 2 #font 999 #width 225) ; "Black Hole Bertha            Place Like a giant interstellar           Stamp vacuum, Black Hole Bertha         Here comes sweeping through the galaxy. All travelers are advised to stay away from Bertha. Just buy the post card, then tell everyone you went there."
			)
			(3
				(Print ; "You examine one of the many interesting post cards."
					471
					0
					#icon
					(LangSwitch 73 318)
					0
					0
					#width
					100
					#button
					{Read Back}
					1
				)
				(Print 471 3 #font 999 #width 225) ; "Ortega               Place The volcanoes of Ortega are         Stamp constantly reshaping its            Here surface. Dressed in heat resistant underwear, the hearty traveler can find a lava lovers paradise on this starkly enjoyable planet."
			)
			(4
				(Print ; "You examine one of the many interesting post cards."
					471
					0
					#icon
					(LangSwitch 73 318)
					0
					3
					#width
					100
					#button
					{Read Back}
					1
				)
				(Print 471 4 #font 999 #width 225) ; "RobertaLand              Place Come join the fun at the           Stamp funpark of the future!             Here See characters from your favorite stories come to life again and again. Recently revised, so don't miss a single thrilling scene."
			)
			(5
				(Print ; "You examine one of the many interesting post cards."
					471
					0
					#icon
					(LangSwitch 73 318)
					1
					0
					#width
					100
					#button
					{Read Back}
					1
				)
				(Print 471 5 #font 999 #width 225) ; "Beta Alpha Starless Region        Place Looking for some real           Stamp solitude? Come to a place          Here that's so far from everything that you can't even see stars. Mind-numbing boredom greets you as you drift aimlessly through nothing. A must for the brain-dead!"
			)
			(6
				(Print ; "You examine one of the many interesting post cards."
					471
					0
					#icon
					(LangSwitch 73 318)
					0
					1
					#width
					100
					#button
					{Read Back}
					1
				)
				(Print 471 6 #font 999 #width 225) ; "Achoron              Place The friendly creatures of          Stamp Achoron are a delight for           Here young and old alike. Tame enough to come right up and caress you, yet wild enough to slash you to shreds if provoked."
			)
		)
		(DisposeScript 471)
	)
)

