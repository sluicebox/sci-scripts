;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1057)
(include sci.sh)
(use Main)
(use interrogation)
(use GKTeller)
(use Array)
(use Talker)
(use Actor)

(public
	gerde 0
	tkGerde 1
)

(local
	local0 = -1
	local1 = -1
)

(instance gerde of Interrogation
	(properties
		curNoun 5
		sayNoun 4
		verb 128
		modNum 57
		color 12
		index 14
		view 983
		left 234
		top 95
	)

	(method (setPersonals)
		(= personals (IntArray with: 55 39 76 36 72 40 47 38))
		(= personalIndex (IntArray with: 1 2 3 4 5 6 7 8))
	)

	(method (showCases)
		(super
			showCases:
				58 ; Where do you think Wolfgang went?
				(and (not (gEgo has: 67)) (IsNotInterrogationFlag 330)) ; bookSnkMnd
				59 ; Do you know when he'll be back?
				(IsNotInterrogationFlag 331)
				60 ; What is he like?
				(IsNotInterrogationFlag 332)
				61 ; What's your relationship with Wolfgang?
				(IsNotInterrogationFlag 333)
				62 ; Can you show me Wolfgang's library?
				(IsNotInterrogationFlag 334)
				39 ; Initiation Ceremony
				(and (IsInterrogationFlag 335) (< gDay 8))
				76 ; Key
				(and (IsNotInterrogationFlag 336) (gEgo has: 68)) ; wolfKey
				36 ; Chapel Panels
				(and (IsFlag 304) (IsNotInterrogationFlag 335))
				72 ; Portal Poem
				(IsFlag 259)
		)
	)

	(method (cue &tmp temp0)
		(switch iconValue
			(64 ; Oh, nothing. Never mind.
				(self goTop:)
				(self doVerb:)
			)
			(63 ; Just tell me anything.
				(= iconValue (+ 65 (mod (++ local0) 5)))
				(self sayMessage:)
			)
			(58 ; Where do you think Wolfgang went?
				(SetInterrogationFlag 330)
				(self doVerb:)
			)
			(59 ; Do you know when he'll be back?
				(SetInterrogationFlag 331)
				(self doVerb:)
			)
			(60 ; What is he like?
				(SetInterrogationFlag 332)
				(self doVerb:)
			)
			(61 ; What's your relationship with Wolfgang?
				(SetInterrogationFlag 333)
				(self doVerb:)
			)
			(62 ; Can you show me Wolfgang's library?
				(SetInterrogationFlag 334)
				(self doVerb:)
			)
			(55 ; Herself
				(= iconValue (+ 51 (mod (++ local1) 4)))
				(self sayMessage:)
			)
			(39 ; Initiation Ceremony
				(= iconValue 70) ; "Tell me about the Schattenj\84ger initiation ceremony."
				(if (SetFlag 261)
					(++ iconValue)
				)
				(gEgo getPoints: 185 1)
				(self sayMessage:)
			)
			(72 ; Portal Poem
				(= iconValue 73) ; "(CURIOUS)There are some words over the locked door in Wolfgang's bedroom. What do they mean?"
				(if (SetInterrogationFlag 337)
					(++ iconValue)
				)
				(gEgo getPoints: 184 1)
				(self sayMessage:)
			)
			(40 ; Ritter Family
				(= iconValue 41) ; "(RESPECTUL OF FAMILY BUT SORROWFUL)I can tell you what they say in the village--what I heard when I was small. To the villagers, the Ritters are a little...how do you say...tragic--to be pitied."
				(if (SetInterrogationFlag 338)
					(++ iconValue)
					(if (SetInterrogationFlag 339)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(47 ; Schloss Ritter
				(= iconValue 37) ; "(ADMIRING)Schloss Ritter has stood for many centuries--no one knows how long. It was once the pride of Bavaria, but now it is in disrepair."
				(if (SetInterrogationFlag 340)
					(= iconValue 48) ; "The castle has many, many rooms and passages, Herr Knight. Most have been closed off and are decaying in the dark and damp. Only a few rooms have been kept up due to the cost."
					(if (SetInterrogationFlag 341)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(14 ; Schattenj\84ger
				(= iconValue 44) ; "(PROUD, THEN EMBARRASSED)As Wolfgang may have told you, Schattenj\84ger means 'Shadow hunter.' The Ritter family have always been Schattenj\84gers. It is a kind of priesthood, though not <blush> as restrictive as most."
				(if (SetInterrogationFlag 342)
					(++ iconValue)
					(if (SetInterrogationFlag 343)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue 56) ; "(NERVOUS)What murders?"
				(if (SetInterrogationFlag 344)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(36 ; Chapel Panels
				(SetInterrogationFlag 335)
				(self doVerb:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance tkGerde of Talker
	(properties
		x 234
		y 95
		talkWidth 200
		modeless 2
		fore 12
		back 0
		view 983
		textX -225
		textY 6
	)

	(method (init)
		(= font gUserFont)
		(cond
			((IsHiRes)
				(if (< view 10000)
					(+= view 10000)
				)
			)
			((> view 10000)
				(-= view 10000)
			)
		)
		(herMouth view: view)
		(herEyes view: view)
		(super init: herMouth 0 herEyes &rest)
	)
)

(instance herMouth of Prop
	(properties
		x 249
		y 129
		view 983
		loop 1
	)
)

(instance herEyes of Prop
	(properties
		x 249
		y 119
		view 983
		loop 2
	)
)

