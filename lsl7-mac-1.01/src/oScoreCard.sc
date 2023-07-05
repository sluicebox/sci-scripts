;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use ModalPlane)
(use PushButton)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Feature)
(use Actor)
(use System)

(public
	oScoreCard 0
)

(procedure (localproc_0) ; UNUSED
	(voHorseshoes cel: 1 init: oScoreCard)
	(voCraps cel: 1 init: oScoreCard)
	(voBowling cel: 1 init: oScoreCard)
	(voLovemaster cel: 1 init: oScoreCard)
	(voCookOff cel: 1 init: oScoreCard)
	(voBestDressed cel: 1 init: oScoreCard)
)

(instance oScoreCard of Plane
	(properties
		picture 4000
		priority 500
	)

	(method (init)
		(super init: 0 0 639 479)
		(self setPri: 500 drawPic: picture)
		(oThyghTitle init: self)
		(oHorseshoes init: self)
		(oCraps init: self)
		(oBowling init: self)
		(oLovemaster init: self)
		(oCookOff init: self)
		(oBestDressed init: self)
		(oChastity init: self)
		(voCrossOut init: self)
		(if ((ScriptID 64017 0) test: 242) ; oFlags
			(if ((ScriptID 64017 0) test: 45) ; oFlags
				(voHorseshoes cel: 1 init: self)
			else
				(voHorseshoes cel: 0 init: self)
			)
		)
		(if ((ScriptID 64017 0) test: 243) ; oFlags
			(if ((ScriptID 64017 0) test: 89) ; oFlags
				(voCraps cel: 1 init: self)
			else
				(voCraps cel: 0 init: self)
			)
		)
		(if ((ScriptID 64017 0) test: 244) ; oFlags
			(if ((ScriptID 64017 0) test: 103) ; oFlags
				(voBowling cel: 1 init: self)
			else
				(voBowling cel: 0 init: self)
			)
		)
		(if ((ScriptID 64017 0) test: 245) ; oFlags
			(if ((ScriptID 64017 0) test: 113) ; oFlags
				(voLovemaster cel: 1 init: self)
			else
				(voLovemaster cel: 0 init: self)
			)
		)
		(if ((ScriptID 64017 0) test: 246) ; oFlags
			(if ((ScriptID 64017 0) test: 115) ; oFlags
				(voCookOff cel: 1 init: self)
			else
				(voCookOff cel: 0 init: self)
			)
		)
		(if ((ScriptID 64017 0) test: 247) ; oFlags
			(if ((ScriptID 64017 0) test: 127) ; oFlags
				(voBestDressed cel: 1 init: self)
			else
				(voBestDressed cel: 0 init: self)
			)
		)
		(foExit init: self)
		(foOpaque init: self)
	)
)

(class HotText of TextItem
	(properties
		isHighlighted 0
		nNewRoom 0
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
		(self fore: 0)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (!= (event plane:) plane)
			(event localize: plane)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (self onMe: event) (self isNotHidden:))
				(if (not isHighlighted)
					(self highlight:)
				)
				(if (& (event type:) evMOUSEBUTTON)
					(= temp1 0)
					(CueObj state: 0 cycles: 0 client: self theVerb: 0)
					(CueObj changeState: 3)
				)
				(event claimed: 1)
				(return)
			)
			(isHighlighted
				(self highlight: 0)
			)
		)
		(return 0)
	)

	(method (highlight param1)
		(if (and argc (not param1))
			(= isHighlighted 0)
			(self fore: 0 draw:)
		else
			(= isHighlighted 1)
			(self fore: 84 draw:)
		)
	)

	(method (doVerb)
		(self highlight: 0)
		(gCurRoom newRoom: nNewRoom)
		(oScoreCard dispose:)
	)
)

(instance voHorseshoes of View
	(properties
		x 351
		y 382
		priority 600
		fixPriority 1
		view 40
	)
)

(instance voCraps of View
	(properties
		x 351
		y 382
		priority 600
		fixPriority 1
		view 40
		loop 1
	)
)

(instance voBowling of View
	(properties
		x 351
		y 382
		priority 600
		fixPriority 1
		view 40
		loop 2
	)
)

(instance voLovemaster of View
	(properties
		x 351
		y 382
		priority 600
		fixPriority 1
		view 40
		loop 3
	)
)

(instance voCookOff of View
	(properties
		x 351
		y 382
		priority 600
		fixPriority 1
		view 40
		loop 4
	)
)

(instance voBestDressed of View
	(properties
		x 351
		y 382
		priority 600
		fixPriority 1
		view 40
		loop 5
	)
)

(instance voChastity of View ; UNUSED
	(properties
		x 351
		y 382
		priority 600
		fixPriority 1
		view 40
		loop 6
	)
)

(instance voCrossOut of View
	(properties
		x 263
		y 349
		priority 601
		fixPriority 1
		view 4005
	)
)

(instance oThyghTitle of TextItem
	(properties
		x 109
		y 80
		priority 610
		fixPriority 1
		font 2510
		mode 2
		border 0
		nLeading 0
	)

	(method (init)
		(self back: skip)
		(= text (MakeMessageText 0 0 13 1 11))
		(super init: &rest)
		(self setScale:)
		(= scaleY (= scaleX 128))
	)
)

(instance oHorseshoes of HotText
	(properties
		x 212
		y 117
		priority 610
		fixPriority 1
		font 2510
		mode 2
		border 0
		nLeading 0
		nNewRoom 250
	)

	(method (init)
		(self back: skip)
		(&= signal $efff)
		(= text (MakeMessageText 0 0 6 1 11))
		(super init: &rest)
		(self setScale:)
		(= scaleY (= scaleX 128))
	)
)

(instance oCraps of HotText
	(properties
		x 226
		y 153
		priority 610
		fixPriority 1
		font 2510
		mode 2
		border 0
		nLeading 0
		nNewRoom 370
	)

	(method (init)
		(self back: skip)
		(&= signal $efff)
		(= text (MakeMessageText 0 0 7 1 11))
		(super init: &rest)
		(self setScale:)
		(= scaleY (= scaleX 128))
	)
)

(instance oBowling of HotText
	(properties
		x 225
		y 188
		priority 610
		fixPriority 1
		font 2510
		mode 2
		border 0
		nLeading 0
		nNewRoom 390
	)

	(method (init)
		(self back: skip)
		(&= signal $efff)
		(= text (MakeMessageText 0 0 8 1 11))
		(super init: &rest)
		(self setScale:)
		(= scaleY (= scaleX 128))
	)
)

(instance oLovemaster of HotText
	(properties
		x 223
		y 225
		priority 610
		fixPriority 1
		font 2510
		mode 2
		border 0
		nLeading 0
		nNewRoom 410
	)

	(method (init)
		(self back: skip)
		(&= signal $efff)
		(= text (MakeMessageText 0 0 9 1 11))
		(super init: &rest)
		(self setScale:)
		(= scaleY (= scaleX 128))
	)
)

(instance oCookOff of HotText
	(properties
		x 215
		y 262
		priority 610
		fixPriority 1
		font 2510
		mode 2
		border 0
		nLeading 0
		nNewRoom 420
	)

	(method (init)
		(self back: skip)
		(&= signal $efff)
		(= text (MakeMessageText 0 0 10 1 11))
		(super init: &rest)
		(self setScale:)
		(= scaleY (= scaleX 128))
	)
)

(instance oBestDressed of HotText
	(properties
		x 222
		y 300
		priority 610
		fixPriority 1
		font 2510
		mode 2
		border 0
		nLeading 0
		nNewRoom 440
	)

	(method (init)
		(self back: skip)
		(&= signal $efff)
		(= text (MakeMessageText 0 0 11 1 11))
		(super init: &rest)
		(self setScale:)
		(= scaleY (= scaleX 128))
	)
)

(instance oChastity of TextItem
	(properties
		x 287
		y 339
		priority 610
		fixPriority 1
		font 2510
		mode 2
		border 0
		nLeading 0
	)

	(method (init)
		(self back: skip)
		(= text (MakeMessageText 0 0 12 1 11))
		(super init: &rest)
		(self setScale:)
		(= scaleY (= scaleX 128))
	)
)

(instance foExit of CUExitFeature
	(properties)

	(method (doVerb)
		(oScoreCard dispose:)
	)
)

(instance foOpaque of OpaqueFeature
	(properties
		nsRight 639
		nsBottom 479
	)
)

(instance soLeave of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self dispose:)
			)
		)
	)
)

