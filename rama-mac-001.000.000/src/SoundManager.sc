;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SaveManager)
(use Array)
(use Sound)
(use System)

(public
	SoundManager 0
)

(local
	local0
	local1 = 1
)

(class SoundManager of RamaRegion
	(properties
		short_Delay 5
		long_Delay 10
		soundLocations 0
		soundList 0
		newComposition 0
		curComposition 0
		curMeasure -1
		curClient 0
		nextClient 0
		counter 0
		volume 127
		cueAction 0
	)

	(method (init)
		(if (not initialized)
			(= soundLocations (Set new:))
			(backgroundMusic owner: self)
		)
		(super init: &rest)
		(self keep: 1)
		(= gSoundManager self)
	)

	(method (dispose)
		(= cueAction 0)
		(= short_Delay 5)
		(= long_Delay 10)
		(if curComposition
			(curComposition dispose:)
		)
		(if newComposition
			(newComposition dispose:)
		)
		(if soundList
			(soundList dispose:)
			(= soundList 0)
		)
		(= nextClient (= curClient (= curComposition (= newComposition 0))))
		(if (and soundLocations (soundLocations size:))
			(soundLocations eachElementDo: #dispose release:)
		)
		(backgroundMusic dispose:)
		(gRegions delete: self)
		(if script
			(script dispose:)
		)
		(if timer
			(timer dispose: delete:)
		)
		(gSounds eachElementDo: #clean self)
		(= gSoundManager 0)
		(= initialized 0)
	)

	(method (setKeep)
		(return 1)
	)

	(method (cue &tmp temp0)
		(switch cueAction
			(2
				(backgroundMusic pause: 1)
			)
			(3
				(backgroundMusic mute: 1)
			)
			(else
				(++ curMeasure)
				(if
					(and
						curComposition
						(< -1 curMeasure (curComposition size:))
					)
					(= temp0 (curComposition at: curMeasure))
				else
					(if curClient
						(curClient cue:)
					)
					(if (> counter 0)
						(-- counter)
					)
					(cond
						(newComposition
							(= curClient nextClient)
							(= nextClient 0)
							(= counter local1)
							(= local1 1)
							(if curComposition
								(curComposition dispose:)
							)
							(= curComposition newComposition)
							(= curMeasure (= newComposition 0))
							(= temp0 (curComposition at: curMeasure))
						)
						((not curComposition)
							(= nextClient (= curClient 0))
							(= curMeasure -1)
							(= counter 0)
							(return)
						)
						((not counter)
							(= nextClient (= curClient 0))
							(= curMeasure -1)
							(backgroundMusic dispose:)
							(return)
						)
						(else
							(= curMeasure 0)
							(= temp0 (curComposition at: curMeasure))
						)
					)
				)
				(backgroundMusic
					number: temp0
					owner: self
					init:
					play: volume self
				)
			)
		)
		(= cueAction 0)
	)

	(method (playMusic param1 param2)
		(cond
			((<= argc 2)
				(if (>= argc 2)
					(= counter param2)
				)
				(= curClient param1)
				(if curComposition
					(= curMeasure 0)
					(backgroundMusic
						number: (curComposition at: curMeasure)
						owner: self
						init:
						play: volume self
					)
				)
			)
			((== curMeasure -1)
				(if (>= argc 2)
					(= counter param2)
				)
				(= curClient param1)
				(if curComposition
					(curComposition dispose:)
				)
				(= curComposition (IntArray newWith: (- argc 2) &rest))
				(= curMeasure 0)
				(backgroundMusic
					number: (curComposition at: curMeasure)
					owner: self
					init:
					play: volume self
				)
			)
			(else
				(if (>= argc 2)
					(= local1 param2)
				else
					(= local1 1)
				)
				(= nextClient param1)
				(if newComposition
					(newComposition dispose:)
				)
				(= newComposition (IntArray newWith: (- argc 2) &rest))
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and local0 (== (backgroundMusic prevSignal:) -1))
			(= local0 0)
			(if newComposition
				(= curClient nextClient)
				(= nextClient 0)
				(= counter local1)
				(= local1 1)
				(curComposition dispose:)
				(= curComposition newComposition)
				(= curMeasure (= newComposition 0))
				(backgroundMusic
					number: (curComposition at: curMeasure)
					owner: self
					init:
					play: volume self
				)
			else
				(= nextClient (= curClient 0))
				(= curMeasure -1)
			)
		)
	)

	(method (fadeMusic param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4)
		(= cueAction 0)
		(cond
			((!= curMeasure -1)
				(if argc
					(= temp0 param1)
				else
					(= temp0 0)
				)
				(if (> argc 1)
					(= temp1 param2)
				else
					(= temp1 20)
				)
				(if (> argc 2)
					(= temp2 param3)
				else
					(= temp2 10)
				)
				(if (> argc 3)
					(= temp3 param4)
				else
					(= temp3 0)
				)
				(if (and (> argc 4) param5)
					(= temp4 param5)
				else
					(= temp4 0)
				)
				(backgroundMusic fade: temp0 temp1 temp2 temp3 temp4)
				(= local0 temp3)
			)
			((and (> argc 4) param5)
				(param5 cue:)
			)
		)
	)

	(method (stopMusic)
		(if (!= curMeasure -1)
			(= curMeasure -1)
			(if curComposition
				(curComposition dispose:)
				(= curComposition 0)
			)
			(if newComposition
				(newComposition dispose:)
				(= newComposition 0)
			)
			(= counter 0)
			(= curMeasure -1)
			(backgroundMusic stop:)
		)
	)

	(method (setMusicVolume param1)
		(if argc
			(if (and (!= (backgroundMusic scratch:) 1) (!= curMeasure -1))
				(backgroundMusic setVol: param1)
			)
			(return (= volume param1))
		else
			(return volume)
		)
	)

	(method (pauseMusic param1 param2 param3 &tmp temp0 temp1)
		(if (!= curMeasure -1)
			(if (> argc 1)
				(= temp0 param2)
			else
				(= temp0 20)
			)
			(if (> argc 2)
				(= temp1 param3)
			else
				(= temp1 10)
			)
			(if param1
				(backgroundMusic fade: 0 temp0 temp1 0 self)
				(backgroundMusic scratch: 1)
				(= cueAction 2)
			else
				(= cueAction 0)
				(backgroundMusic scratch: 0)
				(backgroundMusic signal: 0)
				(backgroundMusic pause: 0)
				(backgroundMusic fade: volume temp0 temp1 0 self)
			)
		)
	)

	(method (muteMusic param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(if (!= curMeasure -1)
			(if (> argc 1)
				(= temp0 param2)
			else
				(= temp0 0)
			)
			(if (> argc 2)
				(= temp1 param3)
			else
				(= temp1 20)
			)
			(if (> argc 3)
				(= temp2 param4)
			else
				(= temp2 10)
			)
			(if param1
				(backgroundMusic fade: 0 temp1 temp2 0 self)
				(= cueAction 3)
			else
				(backgroundMusic mute: 0)
				(backgroundMusic fade: volume temp1 temp2 0 self)
			)
		)
	)

	(method (playSounds param1 &tmp temp0 temp1)
		(cond
			(argc
				(self stopSounds: 1)
				(= soundList (List new:))
				(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
					(= temp1 [param1 temp0])
					(soundList add: temp1)
					(temp1 flags: 5 owner: self loop: 1)
				)
				(self setScript: intermittentSoundsScript)
			)
			(soundList
				(self setScript: intermittentSoundsScript)
			)
		)
	)

	(method (stopSounds param1)
		(if script
			(script dispose:)
			(= script 0)
		)
		(if (and soundList argc param1)
			(soundList dispose:)
			(= soundList 0)
		)
	)

	(method (addSFXLocs)
		(soundLocations add: &rest)
	)

	(method (updateSFXLocs)
		(if (soundLocations size:)
			(soundLocations eachElementDo: #play)
		)
	)

	(method (panSFXLocs)
		(if (soundLocations size:)
			(soundLocations eachElementDo: #pan)
		)
	)

	(method (deleteSFXLoc param1)
		(if (soundLocations size:)
			(soundLocations delete: param1)
		)
	)

	(method (cleanLocs param1 &tmp temp0 temp1 temp2)
		(= temp0 0)
		(while (< temp0 (soundLocations size:))
			(= temp1 (soundLocations at: temp0))
			(if (== (temp1 owner:) param1)
				(self deleteSFXLoc: temp1)
				(temp1 dispose:)
			else
				(++ temp0)
			)
			0
		)
	)

	(method (musicNum)
		(if (>= curMeasure 0)
			(curComposition at: curMeasure)
		)
	)

	(method (serialize param1 param2 &tmp temp0 temp1 temp2)
		(if (and (== argc 2) param2)
			(if param1
				(self number: (SaveManager readWord:))
				(super serialize: param1)
				(= curMeasure (SaveManager readWord:))
				(= counter (SaveManager readWord:))
				(SaveManager readWord:)
				(if (= temp1 (SaveManager readWord:))
					(= curComposition (IntArray newWith: temp1))
					(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
						(curComposition at: temp0 (SaveManager readWord:))
					)
					(if (!= curMeasure -1)
						(backgroundMusic
							number: (curComposition at: curMeasure)
							owner: self
							init:
							play: volume self
						)
					)
				else
					(= curComposition 0)
				)
				(if (= temp1 (SaveManager readWord:))
					(= newComposition (IntArray newWith: temp1))
					(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
						(newComposition at: temp0 (SaveManager readWord:))
					)
				else
					(= newComposition 0)
				)
				(= short_Delay (SaveManager readWord:))
				(= long_Delay (SaveManager readWord:))
				(self init:)
			else
				(super serialize: param1)
				(SaveManager writeWord: curMeasure)
				(SaveManager writeWord: counter)
				(SaveManager writeWord: volume)
				(if curComposition
					(SaveManager writeWord: (curComposition size:))
					(for
						((= temp0 0))
						(< temp0 (curComposition size:))
						((++ temp0))
						
						(SaveManager writeWord: (curComposition at: temp0))
					)
				else
					(SaveManager writeWord: 0)
				)
				(if newComposition
					(SaveManager writeWord: (newComposition size:))
					(for
						((= temp0 0))
						(< temp0 (newComposition size:))
						((++ temp0))
						
						(SaveManager writeWord: (newComposition at: temp0))
					)
				else
					(SaveManager writeWord: 0)
				)
				(SaveManager writeWord: short_Delay)
				(SaveManager writeWord: long_Delay)
			)
		)
	)
)

(instance backgroundMusic of Sound
	(properties
		flags 1
	)
)

(instance intermittentSoundsScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(if (or (SoundManager short_Delay:) (SoundManager long_Delay:))
					(= seconds
						(Random
							(SoundManager short_Delay:)
							(SoundManager long_Delay:)
						)
					)
				else
					(self cue:)
				)
			)
			(1
				(= state -1)
				(= temp1
					(if (< 1 ((SoundManager soundList:) size:))
						(Random 0 (- ((SoundManager soundList:) size:) 1))
					else
						0
					)
				)
				(((SoundManager soundList:) at: temp1) init: play: self)
			)
		)
	)
)

