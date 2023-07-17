;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11940)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm11940 0
)

(instance rm11940 of ExitRoom
	(properties
		picture 11940
		east 1190 ; furnaceRm
		south 1190 ; furnaceRm
		west 1190 ; furnaceRm
	)

	(method (init)
		(Load 140 11940) ; WAVE
		(super init: &rest)
		(pilotButton init:)
		(controlKnob init:)
	)
)

(instance controlKnob of Prop
	(properties
		modNum 1190
		x 192
		y 186
		view 11940
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (and (& (event type:) evMOUSEBUTTON) (self onMe: event))
			(if (IsFlag 746)
				(gMessager say: 11 62 0 0 0 modNum) ; "The fire's going good now. I don't want to mess with the controls."
			else
				((gUser sel_715:) set: 993 1 0)
				(= temp2 (event x:))
				(= temp3 0)
				(= temp4 1)
				(while (not (& ((= temp0 (Event new:)) type:) evMOUSEBUTTON))
					(temp0 localize: plane)
					(cond
						((and (> (= temp1 (temp0 x:)) temp2) (== temp4 0))
							(= temp4 1)
							((gUser sel_715:) set: 993 1 0)
						)
						((and (< temp1 temp2) (== temp4 1))
							(= temp4 0)
							((gUser sel_715:) set: 993 0 0)
						)
					)
					(cond
						((< temp1 68)
							(= cel 0)
						)
						((< temp1 113)
							(= cel 1)
						)
						((< temp1 138)
							(= cel 2)
						)
						((< temp1 168)
							(= cel 3)
						)
						((< temp1 215)
							(= cel 4)
						)
						((< temp1 251)
							(= cel 5)
						)
						((< temp1 281)
							(= cel 6)
						)
						((> temp1 281)
							(= cel 7)
						)
					)
					(if (!= cel temp3)
						(UpdateScreenItem self)
						(FrameOut)
					)
					(= temp3 cel)
					(= temp2 temp1)
					(temp0 dispose:)
				)
				((gUser sel_715:) sel_737:)
				(cond
					((and (IsFlag 798) (> cel 3))
						(SetFlag 746)
						(gGame changeScore: 1155)
						(gMessager say: 14 62 0 0 self modNum) ; "(FIRE LIGHTS UP, PLEASED)There we go."
					)
					((IsFlag 798)
						(gMessager say: 13 62 0 0 0 modNum) ; "(ADJUST FURNACE CONTROLS INCORRECTLY)I don't hear anything."
					)
					(else
						(gMessager say: 12 62 0 0 0 modNum) ; "(TRY TO ADJUST CONTROLS WITHOUT LIGHTING PILOT)I don't think this is working for some reason."
						(self setCycle: Beg)
					)
				)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (cue)
		(gCurRoom newRoom: 1190) ; furnaceRm
	)

	(method (dispose)
		((gUser sel_715:) sel_717: 0)
		(super dispose:)
	)
)

(instance pilotButton of GKFeature
	(properties
		modNum 1190
		x 505
		y 197
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 484 177 527 177 527 217 484 217
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 795)
					(if (IsFlag 798)
						(gMessager say: 10 theVerb 0 0 0 modNum) ; "(TRY TO LIGHT PILOT TWICE)The pilot is already lit."
					else
						(SetFlag 798)
						(gCurRoom setScript: sPlaySounds)
					)
				else
					(gMessager say: 9 theVerb 0 0 0 modNum) ; "(WORRIED, THOUGHTFUL)I'm not sure it's a great idea to light the pilot without any fuel in the furnace."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sPlaySounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfxLightPilot play: self)
			)
			(1
				(gGame changeScore: 1130)
				(self dispose:)
			)
		)
	)
)

(instance sfxLightPilot of Sound
	(properties
		number 11940
	)
)

