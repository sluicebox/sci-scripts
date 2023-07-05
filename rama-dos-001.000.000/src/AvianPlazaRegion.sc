;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 214)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SoundManager)
(use n1111)
(use Sound)
(use System)

(public
	AvianPlazaRegion 0
)

(instance AvianPlazaRegion of RamaRegion
	(properties)

	(method (init)
		(if (and (not initialized) (or (proc1111_24 230) (!= gCurRoomNum 5005))) ; NYAvian5
			(self setScript: soundScript)
		)
		(super init: &rest)
		(= global190 8)
	)

	(method (setKeep)
		(= keep (or (<= 5001 gNewRoomNum 5030) (== gNewRoomNum 6000))) ; NYAvian1, NYAvianTetraCU, avianShaft
	)

	(method (notify)
		(self setScript: soundScript)
	)

	(method (dispose)
		(SoundManager fadeMusic: 0 20 10 1 0)
		(= initialized 0)
		(super dispose:)
	)
)

(instance soundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SoundManager
					playMusic: self 1 (if (IsFlag 230) 5010 else 5015)
				)
				(self setScript: sfxScript)
			)
			(1
				(underSFX owner: client play: setVol: 0 fade: 60 20 2 0 0)
				(= seconds (Random 40 80))
			)
			(2
				(underSFX fade: 0 20 10 1 0)
				(SoundManager playMusic: self 1 5016)
				(= register (Random 10 20))
			)
			(3
				(SoundManager playMusic: self 1 5022)
			)
			(4
				(if (-- register)
					(self changeState: 3)
				else
					(= cycles 1)
				)
			)
			(5
				(underSFX play: setVol: 0 fade: 60 20 2 0 0)
				(= seconds (Random 40 80))
			)
			(6
				(underSFX fade: 0 20 10 1 0)
				(sfxScript dispose:)
				(self init:)
			)
		)
	)
)

(instance underSFX of Sound
	(properties
		number 5024
		loop -1
	)
)

(instance sfxScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 20))
			)
			(1
				(sfx
					owner: AvianPlazaRegion
					number: (Random 5017 5021)
					play: (Random 20 70) self
				)
				(DoAudio 20 (= register (Random 0 100)) (sfx number:) 50) ; AudPan
				(= cycles 30)
			)
			(2
				(DoAudio 20 (- 100 register) (sfx number:) 50) ; AudPan
			)
			(3
				(self init:)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

