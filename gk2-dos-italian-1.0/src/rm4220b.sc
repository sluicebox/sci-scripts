;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42201)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use Motion)
(use Actor)
(use System)

(public
	rm4220b 0
)

(instance rm4220b of TopicRoom
	(properties
		modNum 420
		picture 4222
		BAD_SELECTOR 51
	)

	(method (init)
		(if (and (IsFlag 688) (IsFlag 341))
			(SetFlag 689)
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
				tLudwig1
				tLudwig2
				tBlackWolf
				tMissingPersons1
				tMissingPersons2
				tGettingCash
		)
	)
)

(instance tLudwig1 of Topic
	(properties
		BAD_SELECTOR 246
		BAD_SELECTOR 241
		BAD_SELECTOR 514
		noun 16
	)
)

(instance tLudwig2 of Topic
	(properties
		BAD_SELECTOR 247
		BAD_SELECTOR 242
		BAD_SELECTOR 241
		noun 17
	)
)

(instance tBlackWolf of Topic
	(properties
		BAD_SELECTOR 248
		BAD_SELECTOR 243
		BAD_SELECTOR 514
		noun 18
	)
)

(instance tMissingPersons1 of Topic
	(properties
		BAD_SELECTOR 249
		BAD_SELECTOR 245
		BAD_SELECTOR 218
		noun 19
	)
)

(instance tMissingPersons2 of Topic
	(properties
		BAD_SELECTOR 558
		BAD_SELECTOR 321
		noun 20
		BAD_SELECTOR 420
	)

	(method (BAD_SELECTOR param1)
		(return
			(and
				(== gChapter 5)
				(not (IsFlag BAD_SELECTOR))
				(or
					(and argc param1)
					(not BAD_SELECTOR)
					(IsFlag BAD_SELECTOR)
				)
				(or (not BAD_SELECTOR) (BAD_SELECTOR firstTrue: #sel_834))
			)
		)
	)
)

(instance tGettingCash of Topic
	(properties
		BAD_SELECTOR 559
		BAD_SELECTOR 322
		BAD_SELECTOR 341
		noun 21
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

