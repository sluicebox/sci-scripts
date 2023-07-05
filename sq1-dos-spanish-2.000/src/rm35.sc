;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use DScript)
(use Talker)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm35 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(instance rm35 of SQRoom
	(properties
		picture 35
		style -32759
	)

	(method (init)
		(LoadMany rsVIEW 61 430 135 427 25 328)
		(Load rsSCRIPT 964)
		(LoadMany rsSOUND 436 462 461 460 413)
		(HandsOff)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 170 262 174 253 170 228 170 214 166 213 166 190 155 189 148 208 135 198 131 178 138 152 138 139 130 140 121 108 121 103 148 186 189
					yourself:
				)
		)
		(super init:)
		(ship init: approachVerbs: 3) ; Do
		(ladder init: approachVerbs: 3) ; Do
		(computer init:)
		(chair init:)
		(ledge init:)
		(portal init:)
		(computerPipes init:)
		(windows init:)
		(skimmerStand init:)
		(machinery init:)
		(steamBlowers init:)
		(bigPipes init:)
		(smallPipes init:)
		(dialPipes init:)
		(floor init:)
		(lightBulb3 init: setCycle: Fwd cycleSpeed: 5)
		(lightBulb2 init: setCycle: Fwd cycleSpeed: 8)
		(lightBulb1 init: setCycle: Fwd cycleSpeed: 11)
		(shaft init: setCycle: Rev cycleSpeed: 8)
		(screen init: stopUpd:)
		(whistle init: setScript: blowWhistle 0 (Random 3 7))
		(gEgo init: view: 1 posn: 317 249 ignoreControl: -32768)
		(= local4 0)
		(HandsOff)
		(self setScript: egoEnterRoom)
		(= local3 0)
		(gLongSong number: 463 loop: -1 play:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade: loop: 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((and (gEgo mover:) (== local4 1))
				(= local8 ((User curEvent:) x:))
				(= local9 ((User curEvent:) y:))
				(gCurRoom setScript: standUpPoly)
			)
			((& (gEgo onControl:) $4000)
				(if (!= (gEgo priority:) 13)
					(gEgo setPri: 13)
				)
			)
			((== local4 1) 0)
			((& (gEgo signal:) $0010)
				(gEgo setPri: -1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 35 0) ; "This place is most interesting, indeed. A mixture of both old and new technologies makes you wonder about its origin. Or at least about its tech support. On one side of the chamber is a primitive steam generator. Its pistons, pounding rhythmically, turn steam into useful energy. On the other side is what appears to be a computer console."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 7 setMotion: MoveTo 170 170 self)
			)
			(1
				(gEgo setLoop: -1 observeControl: -32768)
				(Print 35 1) ; "When you step through, the door slides closed with a faint hissing sound. You are alone in a large room full of strange equipment."
				(leader setScript: leaderEnterRoom)
				(self dispose:)
			)
		)
	)
)

(instance workerDoYourThing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(= local2 worker)
				(= cycles 3)
			)
			(2
				(worker
					show:
					x: 0
					y: 139
					setLoop: 8
					cel: 0
					setPri: 4
					setMotion: MoveTo 75 139 self
				)
				(hoverThing init: setLoop: 5 setCycle: Rev)
			)
			(3
				(worker setCycle: End self)
			)
			(4
				(worker setLoop: 9 cel: 0 setCycle: Osc 3 self)
			)
			(5
				(worker setLoop: 8 setCycle: Beg self)
			)
			(6
				(worker setMotion: MoveTo 0 139 self)
			)
			(7
				(worker y: 0 dispose:)
				(hoverThing dispose:)
				(= state -1)
				(= cycles 30)
			)
		)
	)
)

(instance standUpPoly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 183 y: 131 setLoop: 5 cel: 0 setCycle: End self)
			)
			(1
				(NormalEgo 2 1 61)
				(gEgo observeControl: -32768)
				(= local4 0)
				(HandsOn)
				(if
					(and
						(IsObject (CueObj client:))
						((CueObj client:) approachX:)
					)
					(gEgo
						setMotion:
							PolyPath
							((CueObj client:) approachX:)
							((CueObj client:) approachY:)
							CueObj
					)
				else
					(gEgo setMotion: PolyPath local8 local9)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoFlyOut of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== register 1)
			(if (gEgo cel:)
				(gEgo cel: 0)
			)
			(if (OneOf (gSoundEffects prevSignal:) 10 20 30)
				(if (== (gSoundEffects prevSignal:) 30)
					(= cycles 15)
				)
				(gSoundEffects prevSignal: 0)
				(gEgo cel: (+ (gEgo cel:) 1))
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 315 self)
			)
			(1
				(gEgo
					setPri: 14
					view: 25
					setLoop: 1
					cel: 0
					x: 292
					y: 125
					setCycle: End self
				)
			)
			(2
				(gEgo setPri: 10 setLoop: 2 cel: 0 setCycle: End self)
				(SetScore 10 151)
			)
			(3
				(gEgo view: 55 setLoop: 0 cel: 0 setPri: 2)
				(ship dispose:)
				(= register 1)
				(gSoundEffects number: 436 loop: 0 play:)
			)
			(4
				(if (< (Random 0 99) 50)
					(self setScript: backup self)
				else
					(= ticks 18)
				)
			)
			(5
				(= register 0)
				(gSoundEffects fade:)
				(gEgo
					setCycle: Fwd
					setStep: 5 5
					moveSpeed: 0
					setPri: 9
					cycleSpeed: 5
					setMotion: MoveTo 391 110 self
				)
			)
			(6
				(gCurRoom newRoom: 36)
			)
		)
	)
)

(instance backup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: Fwd
					setStep: 8 8
					moveSpeed: 0
					cycleSpeed: 5
					setPri: 9
					setMotion: MoveTo 120 155 self
				)
			)
			(1
				(gEgo cycleSpeed: 0)
				(explosion init: setCycle: End self)
			)
			(2
				(explosion dispose:)
				(Print 35 2) ; "Ooops! Had the darn thing in reverse. I hope nobody saw that."
				(self dispose:)
			)
		)
	)
)

(instance blowWhistle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (++ local1) register)
					(= register (Random 3 7))
					(= local1 0)
				else
					(= state -1)
				)
				(whistle setLoop: 2 cel: 0 setCycle: CT 1 1 self)
			)
			(1
				(whistle setCycle: End)
				(if (not local3)
					(steamSound
						loop: 0
						play:
							(if local6
								40
								127
							)
					)
					(steam init: cel: 0 setCycle: Osc 1 self)
					(steam2 init: cel: 0 setCycle: Osc 1)
				else
					(= cycles 30)
				)
			)
			(2
				(= state -1)
				(steam dispose:)
				(steam2 dispose:)
				(steamSound stop:)
				(whistle setCycle: Beg self)
			)
		)
	)
)

(instance ledge of Feature
	(properties
		x 113
		y 111
		z 60
		nsTop 45
		nsLeft 49
		nsBottom 58
		nsRight 178
		sightAngle 45
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 35 3) ; "There's an upper level, with a balcony and a dark doorway. You can't see much beyond that."
			)
			(3 ; Do
				(Print 35 4) ; "Who do you think you are - Michael Jordan?"
			)
			(12 ; Smell
				(Print 35 5) ; "No particular odor comes from that direction."
			)
			(11 ; Taste
				(Print 35 6) ; "Quit messing around and do what you came here to do. Whatever THAT might've been!"
			)
			(5 ; Talk
				(Print 35 7) ; "You call up to the upper level, but no-one answers."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance computer of Feature
	(properties
		x 160
		y 100
		heading 270
		nsBottom 180
		nsRight 320
		sightAngle 45
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 35 8) ; "A computer console, a bit archaic by the standards of the Arcada, occupies the upper right corner of the room. You notice that it has a cartridge reader, much like the one you remember seeing on the Arcada's computer (except that this one hasn't been blown to smithereens)."
			)
			(3 ; Do
				(if (== ((Inv at: 0) owner:) 35) ; Cartridge
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 60) 30)
						(gEgo setScript: viewCartridge2)
					else
						(gEgo setScript: viewCartridge2 0 1)
					)
				else
					(Print 35 9) ; "You need to insert a cartridge for this to work correctly."
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; Cartridge
						(if (== local4 1)
							(gCurRoom setScript: sittingInsertCart)
						else
							(gCurRoom setScript: standingInsertCart)
						)
					)
					(else
						(proc0_15)
					)
				)
			)
			(12 ; Smell
				(Print 35 10) ; "The computer doesn't smell very interesting."
			)
			(11 ; Taste
				(Print 35 11) ; "This tastes really dull. You decide you'd rather have a cheeseburger, and you wonder: do they have a Monolith Burger somewhere in this neighborhood?"
			)
			(5 ; Talk
				(Print 35 12) ; "This computer is so ancient, it probably doesn't even respond to voice input."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 162
		y 111
		nsTop 95
		nsLeft 140
		nsBottom 125
		nsRight 165
		sightAngle 45
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 35 13) ; "This must be the chair you sit in to operate the computer."
			)
			(3 ; Do
				(if (== local4 0)
					(gCurRoom setScript: sitDown)
				else
					(gCurRoom setScript: standUp)
				)
			)
			(12 ; Smell
				(Print 35 14) ; "From the smell of it, you'd guess that at least one Keronian uses it quite regularly to play one of your favorite computer games: "Name that Body Odor!""
			)
			(11 ; Taste
				(Print 35 15) ; "Licking the chair suddenly seems like a big waste of energy."
			)
			(5 ; Talk
				(Print 35 16) ; "The chair does not respond. What did you expect?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance portal of Feature
	(properties
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 35 17) ; "There seems to be a portal through which the skimmer may exit and enter. It must lead to the surface."
			)
			(3 ; Do
				(Print 35 18) ; "There's no way to force the portal open."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance computerPipes of Feature
	(properties
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 35 19) ; "From the looks of these pipes, even the computer is powered by steam!"
			)
			(3 ; Do
				(Print 35 20) ; "You don't want to touch the pipes - they're probably hot."
			)
			(5 ; Talk
				(Print 35 21) ; "Talking to pipes is considered a sign of insanity on the planet Kerona."
			)
			(12 ; Smell
				(Print 35 22) ; "Smells like some kind of duct tape."
			)
			(11 ; Taste
				(Print 35 23) ; "You'll get a nasty burn on your tongue if you try that."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance windows of Feature
	(properties
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 35 24) ; "What appear to be skylights made from gigantic oysters filter the intense Keronian sunlight down to these lower levels."
			)
			(3 ; Do
				(Print 35 25) ; "You can't reach them. The skylights are much to high."
			)
			(5 ; Talk
				(Print 35 26) ; "You're truly starved for conversation on your intellectual."
			)
			(12 ; Smell
				(Print 35 27) ; "Try as you might, you can't smell the skylights from down there. Just as you are about to pass out from hyper- ventilation, you sensably decide to abandon this particular project."
			)
			(11 ; Taste
				(Print 35 28) ; "Although the skylights look like gigantic oysters, I doubt very much if they would taste anything like them."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skimmerStand of Feature
	(properties
		y 124
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(switch theVerb
			(2 ; Look
				(Print 35 29) ; "The platform under the skimmer looks like it was put together from old steam generator parts."
			)
			(3 ; Do
				(Print 35 30) ; "It doesn't look as though it will budge."
			)
			(5 ; Talk
				(Print 35 31) ; "The skimmer platform has nothing to say to you."
			)
			(12 ; Smell
				(Print 35 32) ; "It smells a lot like everything else around here. Except more so."
			)
			(11 ; Taste
				(Print 35 33) ; "That doesn't seem at all appetizing."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance machinery of Feature
	(properties
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 35 34) ; "The steam generator is a fascinating device in constant motion. It looks like it was assembled following a field trip to the junkyard, but everything appears to be in working order."
			)
			(3 ; Do
				(Print 35 35) ; "It doesn't seem intelligent to mess with it."
			)
			(5 ; Talk
				(Print 35 36) ; "The generator doesn't respond. Perhaps it's based on some form of A.S. (Artificial Stupidity)."
			)
			(12 ; Smell
				(Print 35 37) ; "You catch scents of iron oxide, burning rubber and fusel oil. It makes you momentarily homesick for Mom's cooking."
			)
			(11 ; Taste
				(Print 35 38) ; "This thing looks hot enough to fry your tongue like an egg."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance steamBlowers of Feature
	(properties
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 35 39) ; "Every few seconds, steam escapes from the vents to let off excess pressure."
			)
			(3 ; Do
				(Print 35 40) ; "Even if you could reach it, there's no way you'd stick your hands near those things."
			)
			(5 ; Talk
				(Print 35 41) ; "The Keronians have a place they put people who are in the habit of talking to steam vents."
			)
			(12 ; Smell
				(Print 35 42) ; "You detect no particular odor coming from the steam."
			)
			(11 ; Taste
				(Print 35 43) ; "You were never fond of broiled tongue."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bigPipes of Feature
	(properties
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 35 44) ; "Large metal cylinders form supports for the upper level."
			)
			(3 ; Do
				(Print 35 45) ; "You decide not to. They're so rusty, they might crumble and bring the whole place down."
			)
			(5 ; Talk
				(Print 35 46) ; "The cylinders don't answer, of course."
			)
			(12 ; Smell
				(Print 35 47) ; "You suspect that they smell like rusty metal, since that's what they are made of."
			)
			(11 ; Taste
				(Print 35 48) ; "Licking the cylinder seems like a waste of time and tongue- power."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance smallPipes of Feature
	(properties
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 35 49) ; "These pipes are probably part of a larger network that carries steam to power various Keronian devices."
			)
			(3 ; Do
				(Print 35 50) ; "You get the feeling they might be hot."
			)
			(5 ; Talk
				(Print 35 51) ; "The Keronians are going to think you're loony if you keep talking to inanimate objects."
			)
			(12 ; Smell
				(Print 35 52) ; "All pipes wrapped in duct tape smell alike to you."
			)
			(11 ; Taste
				(Print 35 53) ; "The thought of your tongue stuck, sizzling, to the hot steam pipe is not a pleasant one."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dialPipes of Feature
	(properties
		x 210
		y 84
		onMeCheck 32
		approachX 203
		approachY 134
	)

	(method (init)
		(self approachVerbs: 3 12 11) ; Do, Smell, Taste
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 35 54) ; "These gauges appear to monitor the pressure in the pipes. You think about the thousands of pounds of boiling hot steam in the system, and hope the gauges work."
			)
			(3 ; Do
				(Print 35 55) ; "You tap on a gauge. The needle quivers, then returns to its original position."
			)
			(5 ; Talk
				(Print 35 56) ; "Talking to pipes (or dials) is considered a sign of insanity on the planet Kerona."
			)
			(12 ; Smell
				(Print 35 57) ; "The gauge doesn't smell like anything in particular."
			)
			(11 ; Taste
				(Print 35 58) ; "Don't put your mouth on that - you don't know where it's been!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floor of Feature
	(properties
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 35 59) ; "The floor in this place is made of polished slate. It is impeccably clean. With all this steam, the Keronians undoubtedly use it to steam clean just about everything."
			)
			(3 ; Do
				(Print 35 60) ; "The floor is made of polished slate. It is very smooth to the touch, slightly damp, and quite warm."
			)
			(5 ; Talk
				(Print 35 61) ; "The floor doesn't respond to your witty reparte'."
			)
			(12 ; Smell
				(Print 35 62) ; "A smell of damp, hot stone rises from the floor."
			)
			(11 ; Taste
				(Print 35 63) ; "Although the floor seems pretty clean, you'd rather not put it to the taste... er... test."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance viewCart of View
	(properties
		x 186
		y 121
		view 25
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 35 64) ; "A data cartridge."
			)
			(3 ; Do
				(if (== local4 1)
					(gCurRoom setScript: sittingRetrieveCart)
				else
					(gCurRoom setScript: standingRetrieveCart)
				)
			)
			(12 ; Smell
				(Print 35 65) ; "It smells like it's loaded with data."
			)
			(11 ; Taste
				(Print 35 66) ; "YUCKK! It tastes like... well, not data. That's for sure."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (!= (gEgo x:) 183) (!= (gEgo y:) 131))
					(gEgo setMotion: PolyPath 183 131 self)
				else
					(= state 0)
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveTo 183 131 self)
			)
			(2
				(gEgo view: 25 setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 4 cel: 0 x: 173 y: 115)
				(= local4 1)
				(HandsOn)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 183 y: 131 setLoop: 5 cel: 0 setCycle: End self)
			)
			(1
				(NormalEgo 2 1 61)
				(gEgo observeControl: -32768)
				(= local4 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sittingInsertCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 173 y: 114 setLoop: 4 cel: 0 setCycle: End self)
			)
			(1
				(gSoundEffects number: 303 loop: 1 play:)
				(Print 35 67) ; "The cartridge snaps neatly into the slot and the screen comes alive."
				(viewCart init:)
				(gEgo cel: 0)
				(self setScript: viewCartridge self)
				(gEgo put: 0 35) ; Cartridge
				(screen loop: 4 setCycle: Fwd)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance viewCartridge2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: viewCartridge self register)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance standingInsertCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (!= (gEgo x:) 164) (!= (gEgo y:) 131))
					(gEgo setMotion: PolyPath 164 131 self)
				else
					(= cycles 3)
				)
			)
			(1
				(gEgo setMotion: MoveTo 164 131 self)
			)
			(2
				(gEgo view: 25 setLoop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gSoundEffects number: 303 loop: 1 play:)
				(viewCart init:)
				(self setScript: viewCartridge self)
				(gEgo put: 0 35) ; Cartridge
				(screen loop: 4 setCycle: Fwd)
			)
			(4
				(NormalEgo 0 1 61)
				(gEgo observeControl: -32768)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance standingRetrieveCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (!= (gEgo x:) 164) (!= (gEgo y:) 131))
					(gEgo setMotion: PolyPath 164 131 self)
				else
					(= cycles 3)
				)
			)
			(1
				(gEgo setMotion: MoveTo 164 131 self)
			)
			(2
				(gEgo view: 25 setLoop: 0 cel: 9 setCycle: CT 3 -1 self)
			)
			(3
				(gSoundEffects number: 303 loop: 1 play:)
				(gEgo setCycle: Beg self)
				(viewCart dispose:)
			)
			(4
				(screen loop: 6 cel: 0)
				(NormalEgo 0 1 61)
				(gEgo observeControl: -32768)
				(HandsOn)
				(gEgo get: 0) ; Cartridge
				(self dispose:)
			)
		)
	)
)

(instance sittingRetrieveCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 8
					x: 173
					y: 114
					setLoop: 4
					setCel: 8
					setCycle: CT 6 -1 self
				)
				(viewCart dispose:)
			)
			(1
				(screen loop: 6 cel: 0)
				(gEgo get: 0) ; Cartridge
				(= cycles 1)
			)
			(2
				(gEgo setCycle: CT 3 -1 self)
			)
			(3
				(gSoundEffects number: 303 loop: 1 play:)
				(viewCart dispose:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo setPri: -1)
				(self setScript: standUp self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance viewCartridge of DScript
	(properties)

	(method (restore)
		(super restore: &rest)
		(= local0 0)
	)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				(if register
					(gEgo setMotion: PolyPath 164 131 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if register
					(= register 0)
					(gEgo setHeading: 90 self)
				else
					(= ticks 2)
				)
			)
			(2
				(gLongSong fade:)
				(steamSound stop:)
				(engineSound stop:)
				(worker signal: (| (worker signal:) $0100))
				(= cycles 3)
			)
			(3
				(= local3 1)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2 10)
				(= seconds 2)
			)
			(4
				(self
					save1:
						(Display ; "LOADING"
							35
							68
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 1)
			)
			(5
				(self restore:)
				(= cycles 12)
			)
			(6
				(gLongSong2 number: 413 loop: -1 play:)
				(self
					save1:
						(Display ; "Whoever shall read this: My name is Dr. Slash Vohaul, I am a scientist with The Star Generator Project aboard the Starlab Arcada."
							35
							69
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(7
				(self restore:)
				(= cycles 6)
			)
			(8
				(self
					save1:
						(Display ; "We have just successfully completed development and testing of The Star Generator. During this time I have come to believe that our progress has been monitored by others. I fear that the Sariens may have learned of our mission."
							35
							70
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 16)
			)
			(9
				(self restore:)
				(= cycles 6)
			)
			(10
				(self
					save1:
						(Display ; "If my fears prove true, The Star Generator and the people of our universe are in serious jeopardy."
							35
							71
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(11
				(self restore:)
				(= cycles 6)
			)
			(12
				(self
					save1:
						(Display ; "The Star Generator is a miraculous device. Used as intended, it will help preserve life for eons to come."
							35
							72
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 12)
			)
			(13
				(self restore:)
				(= cycles 6)
			)
			(14
				(self
					save1:
						(Display ; "Used as a device for evil, it would cause the destruction of millions of lives and enslave all who oppose the Sariens."
							35
							73
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 12)
			)
			(15
				(self restore:)
				(= cycles 6)
			)
			(16
				(self
					save1:
						(Display ; "Encoded within this cartridge are all the plans and specifications for the construction of the Star Generator."
							35
							74
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 12)
			)
			(17
				(self restore:)
				(= cycles 6)
			)
			(18
				(self
					save1:
						(Display ; "Should any disaster befall the Star Generator project, scientists would be able to create a duplicate of the Star Generator with this information."
							35
							75
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 12)
			)
			(19
				(self restore:)
				(= cycles 6)
			)
			(20
				(self
					save1:
						(Display ; "Please guard it with your life andreturn it to the Xenon ruling body as quickly as possible."
							35
							76
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(21
				(self restore:)
				(= cycles 6)
			)
			(22
				(SetScore 5 152)
				(Format @temp0 35 77 global184 global184) ; "Important note: The Star Generator is capable of self-destruction. This was introduced to the system as a precaution. To activate it one must enter the code: %4d"
				(self
					save1:
						(Display
							@temp0
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 20)
			)
			(23
				(self restore:)
				(= cycles 6)
			)
			(24
				(self
					save1:
						(Display ; "A five minute time will begin to count down. Beware - anyone within five kilometers of the Star Generator will be in danger once the timer has been initiated. Please be careful and GOOD LUCK !"
							35
							78
							dsALIGN
							alCENTER
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= seconds 16)
			)
			(25
				(self restore:)
				(= cycles 9)
			)
			(26
				(gLongSong2 fade: loop: 0)
				(gLongSong play: 0 fade: 127 25 10 0)
				(gCast eachElementDo: #show)
				((gEgo _head:) hide:)
				(gCurRoom drawPic: 35 10)
				(steam hide:)
				(steam2 hide:)
				(= local3 0)
				(worker dispose:)
				(screen loop: 6 cel: 0 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance ship of Actor
	(properties
		x 292
		y 125
		sightAngle 45
		approachX 301
		approachY 170
		view 135
		loop 3
		priority 10
		signal 16401
		cycleSpeed 6
		moveSpeed 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 35 79) ; "As described, it is a sand skimmer and it looks like it has skimmed quite a bit of sand in its time. On it is a panel which has a small readout, currently dark, and a keyhole with a key in it."
			)
			(3 ; Do
				(gCurRoom setScript: egoFlyOut)
			)
			(12 ; Smell
				(Print 35 80) ; "You note with satisfaction that the skimmer smells exactly like you expected it to."
			)
			(11 ; Taste
				(Print 35 81) ; "Raw skimmer is not one of your favorite dishes."
			)
			(5 ; Talk
				(Print 35 82) ; "The skimmer doesn't appear to activate by voice. See if there's a key."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ladder of View
	(properties
		x 292
		y 126
		z 1
		sightAngle 45
		approachX 301
		approachY 170
		view 135
		loop 3
		cel 1
		priority 11
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 35 83) ; "The ladder appears to have been put here to make it easier to board the skimmer."
			)
			(3 ; Do
				(ship doVerb: 3 &rest)
			)
			(12 ; Smell
				(Print 35 84) ; "Smells like fresh spray paint."
			)
			(11 ; Taste
				(Print 35 85) ; "You're not that hungry."
			)
			(5 ; Talk
				(Print 35 86) ; "The ladder has nothing to say to you."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance explosion of Prop
	(properties
		x 92
		y 173
		view 328
		priority 13
		signal 16400
		cycleSpeed 2
	)
)

(instance lightBulb1 of Prop
	(properties
		x 135
		y 180
		z 21
		sightAngle 45
		view 135
		cel 1
		priority 15
		signal 16
		cycleSpeed 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 35 87) ; "These glass tubes are really quite intriguing - you've never seen anything remotely like them. Must be some radical new technology."
			)
			(3 ; Do
				(Print 35 88) ; "You can't reach them."
			)
			(12 ; Smell
				(Print 35 89) ; "The faint scent of burning dust surrounds the tubes."
			)
			(11 ; Taste
				(Print 35 90) ; "Your tongue would probably stick to those like chops on a griddle."
			)
			(5 ; Talk
				(Print 35 91) ; "Although bright, the glass tubes have little light to shed upon your current situation. In short, they are not sparkling conversationalists."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lightBulb2 of Prop
	(properties
		x 113
		y 180
		z 18
		sightAngle 45
		view 135
		cel 1
		priority 15
		signal 16
		cycleSpeed 2
	)

	(method (doVerb)
		(lightBulb1 doVerb: &rest)
	)
)

(instance lightBulb3 of Prop
	(properties
		x 92
		y 180
		z 12
		sightAngle 45
		view 135
		cel 1
		priority 14
		signal 16
		cycleSpeed 2
	)

	(method (doVerb)
		(lightBulb1 doVerb: &rest)
	)
)

(instance worker of Actor
	(properties
		x 7
		y 167
		description {Keronian worker}
		view 430
		priority 4
		signal 18448
		cycleSpeed 5
		moveSpeed 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 35 92) ; "These people of Kerona sure are an odd-looking lot. You can't pin it down, but you are sure something is different about them."
			)
			(3 ; Do
				(Print 35 93) ; "Don't bother the guy - he's busy."
			)
			(5 ; Talk
				(Print 35 93) ; "Don't bother the guy - he's busy."
			)
			(12 ; Smell
				(Print 35 94) ; "The underarm odor potential of this Keronian is truly staggering. Too bad this place has never heard of deodorant."
			)
			(11 ; Taste
				(Print 35 95) ; "He's got a wrench, and he knows how to use it."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 35 96) ; "He doesn't seem interested in your money. This company must pay pretty well."
					)
					(0 ; Cartridge
						(Print 35 97) ; "He's seen a million of these. So what?"
					)
					(15 ; Widget
						(Print 35 98) ; "He's really too absorbed in his work to pay any attention to the widget."
					)
					(2 ; Gadget
						(Print 35 99) ; "Since this guy has nothing to say to you anyway, translating it will probably amount to about the same thing."
					)
					(5 ; Dehydrated_Water
						(Print 35 100) ; "He's just too busy to care that you're making such a generous gesture."
					)
					(4 ; Knife
						(Print 35 101) ; "The young Keronian is not interested in seeing your toys."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hoverThing of Prop
	(properties
		x 7
		y 167
		view 430
		loop 4
		cel 1
		priority 3
		signal 16400
		cycleSpeed 5
	)

	(method (doit)
		(self x: (- (local2 x:) 0) y: (+ (local2 y:) 21))
		(super doit: &rest)
		(if (and (< 0 x 320) (< 0 y 200) (not local7))
			(= local7 1)
			(hoverSound number: 462 loop: 1 play: hold: 1)
		else
			(= local7 0)
			(hoverSound hold: 0)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 35 102) ; "The Keronian is hovering a meter or so off the floor on what appears to be a Kamen Kruiser, something like the one you used to buzz the family dog with as a young child."
			)
			(3 ; Do
				(Print 35 103) ; "He probably doesn't want you to fool with it."
			)
			(11 ; Taste
				(Print 35 104) ; "When ARE you going to learn not to put strange things in your mouth?"
			)
			(12 ; Smell
				(Print 35 105) ; "There's no fuel odor - this puppy runs on fourteen D cells and a nine volt."
			)
			(5 ; Talk
				(Print 35 106) ; "What's the point of talking to this thing?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance shaft of Prop
	(properties
		x 51
		y 180
		z 35
		sightAngle 45
		view 135
		loop 1
		cel 4
		priority 15
		signal 16
		cycleSpeed 4
	)

	(method (doit)
		(super doit:)
		(if (and (== cel 5) (!= local5 cel) (not local3))
			(engineSound loop: 0 play: (if local6 40 else 127))
		)
		(= local5 cel)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 35 107) ; "The shaft must be part of the steam generator."
			)
			(3 ; Do
				(Print 35 108) ; "It's too far away, but don't worry; in this game you will undoubtedly get the shaft at least once."
			)
			(11 ; Taste
				(Print 35 109) ; "Oh, let's not and just say we did, OK?"
			)
			(12 ; Smell
				(Print 35 110) ; "The smell of grease in this place seems to come from the shaft's general vicinity."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 178
		y 104
		sightAngle 45
		view 135
		loop 6
		signal 1
		cycleSpeed 14
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== loop 6)
					(Print 35 111) ; "There's nothing visible on the computer screen."
				else
					(Print 35 112) ; "The data is being replayed, but you never have much cared for re-runs, have you?"
				)
			)
			(3 ; Do
				(if (== ((Inv at: 0) owner:) 35) ; Cartridge
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 60) 30)
						(gEgo setScript: viewCartridge)
					else
						(gEgo setScript: viewCartridge 0 1)
					)
				else
					(Print 35 113) ; "You might need to insert a data cartridge for this thing to work."
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; Cartridge
						(if (== local4 1)
							(gCurRoom setScript: sittingInsertCart)
						else
							(gCurRoom setScript: standingInsertCart)
						)
					)
					(else
						(proc0_15)
					)
				)
			)
			(else
				(computer doVerb: theVerb &rest)
			)
		)
	)
)

(instance whistle of Prop
	(properties
		x 22
		y 180
		z 89
		sightAngle 45
		view 135
		loop 2
		priority 6
		signal 16400
		cycleSpeed 17
	)

	(method (doVerb)
		(steamBlowers doVerb: &rest)
	)
)

(instance leader of Actor
	(properties
		x 7
		y 152
		description {Keronian leader.}
		view 427
		priority 4
		signal 18448
		cycleSpeed 5
		moveSpeed 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 35 114) ; "The old Keronian guy looks friendly enough, but his color makes you wonder if he's getting enough oxygen."
			)
			(3 ; Do
				(Print 35 115) ; "He doesn't seem interested in shaking hands, though he certainly has enough of them."
			)
			(5 ; Talk
				(Print 35 116) ; "He seems to have said everything he wants to say to you."
			)
			(12 ; Smell
				(Print 35 117) ; "That wouldn't be at all polite."
			)
			(11 ; Taste
				(Print 35 118) ; "You're not really that rude."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 35 119) ; "All my needs are provided by the Company. I have no need of money."
					)
					(0 ; Cartridge
						(Print 35 120) ; "Your data cartridge resembles the ones we use to store information."
					)
					(15 ; Widget
						(Print 35 121) ; "Be careful not to get that magnetic device too close to my hover platform. It could have a negative effect on the circuitry."
					)
					(2 ; Gadget
						(Print 35 122) ; "Since you understand him fine, you figure either the gadget is already working or he's speaking perfect Xenonian."
					)
					(5 ; Dehydrated_Water
						(Print 35 123) ; "Thank you, strange one, but we have all the water we need here underground. you should save what little you have for the desert."
					)
					(4 ; Knife
						(Print 35 124) ; "Ah, a genuine Xenon Army Knife. My youngest son got one of those in his last package of Hackersnaxs."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance steam of Prop
	(properties
		x 28
		y 55
		sightAngle 45
		view 135
		loop 5
		cel 2
		priority 5
		signal 17
		cycleSpeed 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 35 125) ; "Some steam is escaping from the generator. That explains why this place is so humid."
			)
			(3 ; Do
				(proc0_15)
			)
			(11 ; Taste
				(Print 35 126) ; "If you could taste the steam, you might detect a bit of sulfur. But, since you can't, you don't."
			)
			(12 ; Smell
				(Print 35 127) ; "The steam is too far away for you to smell directly. However, there is a trace of sulfur in the air."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance steam2 of Prop
	(properties
		x 40
		y 69
		description {steam escaping from the pipes.}
		sightAngle 45
		view 135
		loop 5
		cel 1
		priority 5
		signal 17
		cycleSpeed 5
	)

	(method (doVerb)
		(steam doVerb: &rest)
	)
)

(instance hoverSound of Sound
	(properties
		number 462
	)
)

(instance engineSound of Sound
	(properties
		number 461
	)
)

(instance steamSound of Sound
	(properties
		number 460
	)
)

(instance leaderTalker of Talker
	(properties
		x 40
		y 9
		nsTop 4
		nsLeft 207
		view 505
		loop 1
	)
)

(instance leaderBust of View
	(properties
		view 505
		loop 1
		cel 1
	)
)

(instance leaderMouth of Prop
	(properties
		nsTop 58
		nsLeft 17
		view 505
		loop 5
		cycleSpeed 15
	)
)

(instance leaderEyes of Prop
	(properties
		nsTop 28
		nsLeft 15
		view 505
		loop 3
		cycleSpeed 35
	)
)

(instance leaderEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 leader)
				(hoverThing init: setCycle: Fwd)
				(leader
					init:
					cycleSpeed: 8
					moveSpeed: 0
					setMotion: MoveTo 127 122 self
				)
			)
			(1
				(= cycles 20)
			)
			(2
				(leader setCycle: End self)
			)
			(3
				(hoverSound fade: 40 25 10 0)
				(gLongSong setVol: 40)
				(= local6 1)
				(gLongSong2 number: 458 loop: -1 flags: 1 play:)
				(leaderTalker
					posn: 100 120
					init:
						leaderBust
						leaderMouth
						leaderEyes
						{"Please, don't be alarmed. We intend no harm. We are a peaceful race. We are cautious, however. Others don't share our way of life. Welcome to Kerona."}
						0
						0
						0
						self
				)
			)
			(4
				(leaderTalker
					say:
						{"You are standing in the power generation facility of our underground settlement. All power here is produced by steam. That is unimportant to you, however. We have promised you transportation."}
						0
						0
						0
						self
				)
			)
			(5
				(leaderTalker
					say:
						{"It is a Skimmer. It hovers approximately 1/2 meter above the traveling surface. This is very important because of Grell."}
						0
						0
						0
						self
				)
			)
			(6
				(leaderTalker
					say:
						{"Grell and his like dwell in caves below the sand. If you stand on the surface too long, you chance becoming a rare moist meal for him."}
						0
						0
						0
						self
				)
			)
			(7
				(leaderTalker
					say:
						{"The skimmer is programmed to take you to a settlement on the other side of Kerona called Ulence Flats. You can make further travel arrangements there."}
						0
						0
						0
						self
				)
			)
			(8
				(leaderTalker
					say:
						{"I am sorry this is all we can offer. I hope your trip is a safe one. Board the skimmer when you are ready to depart. Good luck, strange one."}
						0
						0
						1
						self
				)
			)
			(9
				(= local6 0)
				(hoverSound fade: 127 25 10 0)
				(gLongSong fade: 127 25 10 0)
				(gLongSong2 flags: 0 fade:)
				(leader xStep: 5)
				(= cycles 2)
			)
			(10
				(leader setCycle: Beg self)
				(HandsOn)
			)
			(11
				(leader setMotion: MoveTo 1 122 self)
			)
			(12
				(leader dispose:)
				(hoverThing dispose:)
				(worker init: hide: setScript: workerDoYourThing)
				(= cycles 1)
			)
			(13
				(self dispose:)
			)
		)
	)
)

