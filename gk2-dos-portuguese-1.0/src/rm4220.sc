;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42200)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use Motion)
(use Actor)
(use System)

(public
	rm4220 0
)

(instance rm4220 of TopicRoom
	(properties
		modNum 420
		picture 4222
		south 420 ; uberRm
		BAD_SELECTOR 42
	)

	(method (init)
		(if (and (IsFlag 435) (IsFlag 432))
			(SetFlag 429)
		)
		(if (not BAD_SELECTOR)
			(gEgo
				setScale: 0
				view: 20073
				setLoop: 0 1
				cel: 0
				posn: 391 333
				init:
				setScript: sFidget
			)
			(pUbergrau init: setScript: sUbergrauFidget)
		)
		(super
			init:
				tUbergrau
				tMunich
				tEstate
				tKillings
				tAnalysis
				tJagdschein
				tPapers
				tDieKoniglich
		)
	)
)

(instance tUbergrau of Topic
	(properties
		BAD_SELECTOR 74
		BAD_SELECTOR 109
		noun 5
	)
)

(instance tMunich of Topic
	(properties
		BAD_SELECTOR 75
		BAD_SELECTOR 110
		noun 6
	)
)

(instance tEstate of Topic
	(properties
		BAD_SELECTOR 76
		BAD_SELECTOR 111
		noun 7
	)
)

(instance tKillings of Topic
	(properties
		BAD_SELECTOR 78
		BAD_SELECTOR 112
		noun 8
	)
)

(instance tAnalysis of Topic
	(properties
		BAD_SELECTOR 79
		BAD_SELECTOR 26
		BAD_SELECTOR 429
		noun 9
	)
)

(instance tJagdschein of Topic
	(properties
		BAD_SELECTOR 80
		BAD_SELECTOR 114
		BAD_SELECTOR 434
		noun 10
	)
)

(instance tPapers of Topic
	(properties
		BAD_SELECTOR 81
		BAD_SELECTOR 115
		BAD_SELECTOR 230
		noun 11
	)
)

(instance tDieKoniglich of Topic
	(properties
		BAD_SELECTOR 84
		BAD_SELECTOR 116
		BAD_SELECTOR 412
		noun 14
	)
)

(instance pUbergrau of Prop
	(properties
		x 202
		y 215
		view 21073
	)
)

(instance sUbergrauFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(pUbergrau cel: 0 setCycle: End)
				(= seconds (Random 3 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 12 25))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

