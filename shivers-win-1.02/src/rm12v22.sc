;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12220)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v22 0
)

(instance rm12v22 of ShiversRoom
	(properties
		picture 12220
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (IsFlag 10)
			((View new:) view: 12220 cel: 0 setPri: 25 1 init:)
			(hsPaper init:)
		)
		(if (IsFlag 9)
			((View new:) view: 12220 cel: 1 setPri: 25 1 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12240
	)

	(method (init)
		(if (IsFlag 9)
			(self createPoly: 52 144 62 115 65 103 79 84 79 39 66 10 0 0 0 142)
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12180
	)

	(method (init)
		(if (IsFlag 10)
			(self
				createPoly: 143 142 143 140 136 139 126 136 126 116 140 116 158 116 158 133 144 139 143 142 229 144 173 102 158 98 161 73 164 58 164 44 136 30 111 42 111 58 102 78 103 91 27 143
			)
		else
			(self
				createPoly: 29 143 102 92 103 77 106 69 155 69 153 72 147 82 147 98 177 103 231 144
			)
		)
		(super init: &rest)
	)
)

(instance hsPaper of HotSpot
	(properties)

	(method (init)
		(self createPoly: 134 132 134 123 146 127 146 132 140 134)
		(super init: &rest)
	)

	(method (doVerb)
		(efExitLeft dispose:)
		(efExitRight dispose:)
		(efExitForward dispose:)
		(spMap init: setPri: 200 1)
		(self dispose:)
	)
)

(instance spMap of ShiversProp
	(properties
		view 12221
	)

	(method (doVerb)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(hsPaper init:)
		(self dispose:)
	)
)

