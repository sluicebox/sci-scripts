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
		dialogDoneFlag 42
	)

	(method (init)
		(if (and (IsFlag 435) (IsFlag 432))
			(SetFlag 429) ; enable "Sample Analysis"
		)
		(if (not checking)
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

(instance tUbergrau of Topic ; "Himself"
	(properties
		sceneNum 74
		flagNum 109
		noun 5
	)
)

(instance tMunich of Topic ; "Munich"
	(properties
		sceneNum 75
		flagNum 110
		noun 6
	)
)

(instance tEstate of Topic ; "Ritter Estate"
	(properties
		sceneNum 76
		flagNum 111
		noun 7
	)
)

(instance tKillings of Topic ; "Mutilation Killings"
	(properties
		sceneNum 78
		flagNum 112
		noun 8
	)
)

(instance tAnalysis of Topic ; "Sample Analysis"
	(properties
		sceneNum 79
		flagNum 26
		readyFlagNum 429
		noun 9
	)
)

(instance tJagdschein of Topic ; "Jagdschein"
	(properties
		sceneNum 80
		flagNum 114
		readyFlagNum 434
		noun 10
	)
)

(instance tPapers of Topic ; "Ritter Family Papers"
	(properties
		sceneNum 81
		flagNum 115
		readyFlagNum 230 ; "I'm an avid hunter." in rm4320
		noun 11
	)
)

(instance tDieKoniglich of Topic ; "Die K\94niglich-Bayrische Hofjagdloge"
	(properties
		sceneNum 84
		flagNum 116
		readyFlagNum 412
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

