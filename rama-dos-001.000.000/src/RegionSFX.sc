;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use SaveManager)
(use Array)
(use Sound)
(use System)

(class RegionSFX of Sound
	(properties
		heading 0
		loop -1
		proximities 0
		curVol 127
	)

	(method (dispose)
		(super dispose:)
	)

	(method (setVol param1)
		(= curVol param1)
		(super setVol: curVol)
	)

	(method (setProx)
		(if argc
			(= proximities (IntArray newWith: argc &rest))
		)
	)

	(method (pan param1 &tmp temp0)
		(cond
			((or (not handle) (not proximities)) 0)
			(argc
				(DoAudio 20 param1 number 0) ; AudPan
			)
			(else
				(DoAudio
					20 ; AudPan
					(-
						50
						(SinMult
							(umod (- (gCurRoom heading:) heading) 360)
							50
						)
					)
					number
					0
				)
			)
		)
	)

	(method (play param1 &tmp temp0 temp1)
		(cond
			(proximities
				(= temp1 0)
				(for ((= temp0 0)) (< temp0 (proximities size:)) ((+= temp0 3))
					(if (== gCurRoomNum (proximities at: temp0))
						(= temp1 1)
						(if (not handle)
							(self pan:)
							(super
								play:
									(proximities at: (+ temp0 1))
									(if argc param1 else 0)
							)
						else
							(self setVol: (proximities at: (+ temp0 1)))
							(self pan:)
						)
						(= heading (proximities at: (+ temp0 2)))
						(break)
					)
				)
				(if (not temp1)
					(self stop:)
					(if argc
						(param1 cue: self)
					)
				)
			)
			((== argc 0)
				(super play: curVol 0)
			)
			((< argc 2)
				(super play: curVol param1)
			)
			(else
				(super play: param1 &rest)
			)
		)
	)

	(method (serialize param1 &tmp temp0 temp1)
		(if param1
			(if proximities
				(proximities dispose:)
				(self proximities: 0)
			)
			(self number: (SaveManager readWord:))
			(self loop: (SaveManager readWord:))
			(self heading: (SaveManager readWord:))
			(self owner: (ScriptID (SaveManager readWord:) 0))
			(if (= temp1 (SaveManager readWord:))
				(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
					(proximities at: temp0 (SaveManager readWord:))
				)
			)
		else
			(SaveManager writeWord: number)
			(SaveManager writeWord: loop)
			(SaveManager writeWord: heading)
			(SaveManager writeWord: (owner number:))
			(if proximities
				(SaveManager writeWord: (proximities size:))
				(for ((= temp0 0)) (< temp0 (proximities size:)) ((++ temp0))
					(SaveManager writeWord: (proximities at: temp0))
				)
			else
				(SaveManager writeWord: 0)
			)
		)
	)
)

