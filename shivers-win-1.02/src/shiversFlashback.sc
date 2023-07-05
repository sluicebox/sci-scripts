;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 991)
(include sci.sh)
(use Main)
(use n951)
(use soundRoom)
(use System)

(public
	shiversFlashback 0
)

(local
	local0
)

(instance aSound of ShiversSound
	(properties)
)

(instance shiversFlashback of ShiversRoom
	(properties
		picture 991
	)

	(method (init)
		(SetFlag 45)
		(spIntro init:)
		(spCancel init:)
		(if (or (IsFlag 29) (IsFlag 87))
			(spBeth init:)
		else
			(spBeth init: loop: 19)
		)
		(if (or (IsFlag 27) (IsFlag 87))
			(spMerrick init:)
		else
			(spMerrick init: loop: 19)
		)
		(if (or (IsFlag 5) (IsFlag 87))
			(spProf init:)
		else
			(spProf init: loop: 19)
		)
		(if (or (IsFlag 46) (IsFlag 87))
			(spAstrology init:)
		else
			(spAstrology init: loop: 19)
		)
		(if (or (IsFlag 47) (IsFlag 87))
			(spScrap init:)
		else
			(spScrap init: loop: 19)
		)
		(if (or (IsFlag 48) (IsFlag 87))
			(spBrochure init:)
		else
			(spBrochure init: loop: 19)
		)
		(if (or (IsFlag 48) (IsFlag 87))
			(spBrochure init:)
		else
			(spBrochure init: loop: 19)
		)
		(if (or (IsFlag 74) (IsFlag 87))
			(spUnexplained init:)
		else
			(spUnexplained init: loop: 19)
		)
		(if (or (IsFlag 4) (IsFlag 87))
			(spHeiroglyphics init:)
		else
			(spHeiroglyphics init: loop: 19)
		)
		(if (or (IsFlag 49) (IsFlag 87))
			(spPictograph init:)
		else
			(spPictograph init: loop: 19)
		)
		(if (or (IsFlag 50) (IsFlag 87))
			(spStars init:)
		else
			(spStars init: loop: 19)
		)
		(if (or (IsFlag 51) (IsFlag 87))
			(spBook init:)
		else
			(spBook init: loop: 19)
		)
		(if (or (IsFlag 52) (IsFlag 87))
			(spTheatre init:)
		else
			(spTheatre init: loop: 19)
		)
		(if (or (IsFlag 53) (IsFlag 87))
			(spBlueprint init:)
		else
			(spBlueprint init: loop: 19)
		)
		(if (or (IsFlag 54) (IsFlag 87))
			(spAddress init:)
		else
			(spAddress init: loop: 19)
		)
		(if (or (IsFlag 55) (IsFlag 87))
			(spMerricksNotebook init:)
		else
			(spMerricksNotebook init: loop: 19)
		)
		(if (or (IsFlag 56) (IsFlag 87))
			(spDiary init:)
		else
			(spDiary init: loop: 19)
		)
		(if (or (IsFlag 57) (IsFlag 87))
			(spFinale init:)
		else
			(spFinale init: loop: 19)
		)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance spIntro of ShiversProp
	(properties
		x 10
		y 23
		view 991
		loop 3
	)

	(method (doVerb)
		(= local0 930)
		(self setScript: sButton)
	)
)

(instance spBeth of ShiversProp
	(properties
		x 10
		y 35
		view 991
		loop 4
	)

	(method (doVerb)
		(= local0 932)
		(self setScript: sButton)
	)
)

(instance spMerrick of ShiversProp
	(properties
		x 10
		y 47
		view 991
		loop 5
	)

	(method (doVerb)
		(= local0 933)
		(self setScript: sButton)
	)
)

(instance spProf of ShiversProp
	(properties
		x 10
		y 59
		view 991
		loop 2
	)

	(method (doVerb)
		(= local0 931)
		(self setScript: sButton)
	)
)

(instance spAstrology of ShiversProp
	(properties
		x 10
		y 71
		view 991
		loop 6
	)

	(method (doVerb)
		(= local0 24502)
		(self setScript: sButton)
	)
)

(instance spScrap of ShiversProp
	(properties
		x 10
		y 83
		view 991
		loop 7
	)

	(method (doVerb)
		(= local0 6221)
		(self setScript: sButton)
	)
)

(instance spBrochure of ShiversProp
	(properties
		x 10
		y 95
		view 991
		loop 8
	)

	(method (doVerb)
		(= local0 9902)
		(self setScript: sButton)
	)
)

(instance spUnexplained of ShiversProp
	(properties
		x 10
		y 107
		view 991
		loop 9
	)

	(method (doVerb)
		(= local0 8222)
		(self setScript: sButton)
	)
)

(instance spHeiroglyphics of ShiversProp
	(properties
		x 10
		y 119
		view 991
		loop 1
	)

	(method (doVerb)
		(= local0 3111)
		(self setScript: sButton)
	)
)

(instance spPictograph of ShiversProp
	(properties
		x 140
		y 23
		view 991
		loop 10
	)

	(method (doVerb)
		(= local0 8223)
		(self setScript: sButton)
	)
)

(instance spStars of ShiversProp
	(properties
		x 140
		y 35
		view 991
		loop 11
	)

	(method (doVerb)
		(= local0 8224)
		(self setScript: sButton)
	)
)

(instance spBook of ShiversProp
	(properties
		x 140
		y 47
		view 991
		loop 12
	)

	(method (doVerb)
		(= local0 8221)
		(self setScript: sButton)
	)
)

(instance spTheatre of ShiversProp
	(properties
		x 140
		y 59
		view 991
		loop 13
	)

	(method (doVerb)
		(= local0 934)
		(self setScript: sButton)
	)
)

(instance spBlueprint of ShiversProp
	(properties
		x 140
		y 71
		view 991
		loop 14
	)

	(method (doVerb)
		(= local0 12182)
		(self setScript: sButton)
	)
)

(instance spAddress of ShiversProp
	(properties
		x 140
		y 83
		view 991
		loop 15
	)

	(method (doVerb)
		(= local0 10204)
		(self setScript: sButton)
	)
)

(instance spMerricksNotebook of ShiversProp
	(properties
		x 140
		y 95
		view 991
		loop 16
	)

	(method (doVerb)
		(= local0 21115)
		(self setScript: sButton)
	)
)

(instance spDiary of ShiversProp
	(properties
		x 140
		y 107
		view 991
		loop 17
	)

	(method (doVerb)
		(= local0 37252)
		(self setScript: sButton)
	)
)

(instance spFinale of ShiversProp
	(properties
		x 140
		y 119
		view 991
		loop 18
	)

	(method (doVerb)
		(= local0 935)
		(self setScript: sButton)
	)
)

(instance spCancel of ShiversProp
	(properties
		x 85
		y 135
		priority 254
		fixPriority 1
		view 991
	)

	(method (doVerb)
		(ClearFlag 45)
		(= local0 990)
		(self setScript: sButton)
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (client loop:) 19)
					(= state 2)
				)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(client cel: 1)
				(aSound number: 15025 play: 90 self)
			)
			(2
				(gGame handsOn:)
				(client cel: 0)
				(gCurRoom newRoom: local0)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

