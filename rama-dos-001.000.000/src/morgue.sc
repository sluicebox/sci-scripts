;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use RamaRoom)
(use InvInitialize)
(use SoundManager)
(use easyPickins)
(use VMDMovie)
(use Plane)
(use Feature)
(use System)

(public
	morgue 0
)

(procedure (localproc_0)
	(switch gPrevRoomNum
		(3071 ; london_Attack
			(spiderDeath play:)
		)
		(8060 ; HumanDeath1
			(spiderDeath play:)
		)
		(8070 ; HumanDeath2
			(spiderDeath play:)
		)
		(8080 ; HumanDeath3
			(spiderDeath play:)
		)
		(8090 ; HumanDeath4
			(spiderDeath play:)
		)
		(2000 ; cplains
			(gGame panelObj: gGame panelSelector: 636)
			0
		)
		(2100 ; CPIceport1
			(gGame panelObj: gGame panelSelector: 636)
			0
		)
		(2070 ; encounterCloseup
			(switch global411
				(2
					(crabDeath play:)
				)
				(3
					(spiderDeath play:)
				)
			)
		)
		(2061 ; CPLondon2
			(genericDeath play:)
		)
		(2062 ; CPLondon3
			(genericDeath play:)
		)
		(6911 ; mirmicatPoolCloseUp
			(genericDeath play:)
		)
		(6005 ; avianLeftShaft3
			(genericDeath play:)
		)
		(else
			(= global178 911)
			(nuclearDeath play:)
		)
	)
)

(instance morgue of RamaRoom
	(properties
		picture 90
	)

	(method (init)
		(if (gGame script:)
			((gGame script:) dispose:)
		)
		(SoundManager fadeMusic: 0 20 10 1)
		(SoundManager stopMusic:)
		(localproc_0)
		((= plane (Plane new:))
			init: 0 0 640 480
			priority: 255
			addCast: deathCast
		)
		(super init:)
		(gCast add: deathCast)
		(retryBtn init: deathCast)
		(restoreBtn init: deathCast)
		(quitBtn init: deathCast)
		(gTheCursor setNormalCursor:)
		(proc70_14)
		(gInventory dispose:)
	)

	(method (dispose)
		(gCast delete: deathCast)
		(DisposeScript 1015)
		(super dispose:)
	)
)

(instance deathCast of Cast
	(properties)
)

(instance retryBtn of GenButton
	(properties
		x 116
		y 347
		loop 8
		view 1015
	)

	(method (action)
		(gGame panelObj: gGame panelSelector: 771)
	)
)

(instance restoreBtn of GenButton
	(properties
		x 268
		y 341
		loop 9
		view 1015
	)

	(method (action)
		(gGame panelObj: gGame panelSelector: 637)
	)
)

(instance quitBtn of GenButton
	(properties
		x 424
		y 353
		loop 10
		view 1015
	)

	(method (action)
		(gGame panelObj: gGame panelSelector: 643)
	)
)

(instance spiderDeath of VMDMovie
	(properties
		movieName 39211
	)
)

(instance genericDeath of VMDMovie
	(properties
		movieName 39511
	)

	(method (play)
		(if (<= global188 3)
			(self cacheSize: 800 preLoadPCT: 80)
		)
		(super play: &rest)
	)
)

(instance crabDeath of VMDMovie
	(properties
		movieName 39511
	)

	(method (play)
		(if (<= global188 3)
			(self cacheSize: 800 preLoadPCT: 80)
		)
		(super play: &rest)
	)
)

(instance nuclearDeath of VMDMovie
	(properties
		movieName 39311
	)
)

(instance cursorCatcher of Feature ; UNUSED
	(properties
		nsBottom 292
		nsRight 592
	)

	(method (init)
		(super init:)
		(self setHotspot: 2)
	)

	(method (doVerb)
		(return 1)
	)
)

